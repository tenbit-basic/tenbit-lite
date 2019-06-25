package cn.tenbit.hare.core.lite.structure.memqueue;

import cn.tenbit.hare.core.lite.constant.HareConsts;
import cn.tenbit.hare.core.lite.exception.HareException;
import cn.tenbit.hare.core.lite.util.HareAssertUtils;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 17:43
 */
public class HareConcurrentMemoryQueue<T extends Comparable> extends AbstractHareMemoryQueue<T> implements HareMemoryQueue<T>, HareMemoryQueueStatus {

    private final Set<T> queue = new ConcurrentSkipListSet<>();

    private final AtomicInteger size = new AtomicInteger(0);

    private final Lock lock = new ReentrantLock();

    private final Semaphore sign = new Semaphore(1);

    private final Status status = new Status(this);

    public HareConcurrentMemoryQueue() {
    }

    public HareConcurrentMemoryQueue(int maxSize) {
        super(maxSize);
    }

    @Override
    public int size() {
        return size.get();
    }

    private int getQueueSize() {
        return queue.size();
    }

    @SuppressWarnings(HareConsts.SUPPRESS_WARNING_UNCHECKED)
    @Override
    public Status getStatus() {
        return status.get();
    }

    public static class Status {

        private final HareMemoryQueue queue;

        private final Lock lock = new ReentrantLock();

        @Getter
        private volatile int maxSize;
        @Getter
        private volatile int currentSize;
        @Getter
        private volatile int queueSize;

        private Status(HareMemoryQueue queue) {
            this.queue = queue;
        }

        private void tryRefresh() {
            try {
                if (!lock.tryLock()) {
                    return;
                }
                this.maxSize = queue.getMaxSize();
                this.currentSize = queue.size();
                this.queueSize = ((HareConcurrentMemoryQueue) queue).getQueueSize();
            } finally {
                lock.unlock();
            }
        }

        private Status get() {
            this.tryRefresh();
            return this;
        }
    }

    @Override
    public boolean offer(T element) {
        HareAssertUtils.notNull(element);

        if (checkIfOverflow()) {
            return handleOverflow(element);
        }

        boolean result = queue.add(element);
        if (result) {
            size.incrementAndGet();
            sign.release();
        }
        return result;
    }

    @Override
    public List<T> batchPoll(int expectSize, TimeUnit timeUnit, long timeOut) {
        return batchGet(expectSize, timeUnit, timeOut, false);
    }

    @Override
    public List<T> batchTake(int expectSize) {
        return batchGet(expectSize, null, UNLIMITED, true);
    }

    private boolean lock(TimeUnit timeUnit, long timeOut) throws InterruptedException {
        if (timeOut == UNLIMITED) {
            lock.lock();
            return true;
        }
        return lock.tryLock(timeOut, timeUnit);
    }

    private List<T> batchGet(int expectSize, TimeUnit timeUnit, long timeOut, boolean waitIfNotFull) {
        HareAssertUtils.isTrue(expectSize > 0);
        try {
            if (!lock(timeUnit, timeOut)) {
                return Collections.emptyList();
            }

            List<T> list = new ArrayList<>(expectSize);
            while (true) {
                for (T element : queue) {
                    list.add(element);
                    if (list.size() == expectSize) {
                        break;
                    }
                }
                if (!waitIfNotFull) {
                    break;
                }
                sign.acquire();
            }

            for (T element : list) {
                boolean result = queue.remove(element);
                if (result) {
                    size.decrementAndGet();
                }
            }

            return list;
        } catch (Exception e) {
            throw HareException.of(e);
        } finally {
            lock.unlock();
        }
    }
}
