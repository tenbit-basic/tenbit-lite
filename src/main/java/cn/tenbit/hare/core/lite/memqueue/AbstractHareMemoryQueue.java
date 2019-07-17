package cn.tenbit.hare.core.lite.memqueue;

import cn.tenbit.hare.core.lite.memqueue.policy.DefaultRejectOverflowPolicy;
import cn.tenbit.hare.core.lite.memqueue.policy.HareMemoryQueueOverflowPolicy;
import cn.tenbit.hare.core.lite.util.HareFunctionUtils;
import cn.tenbit.hare.core.lite.util.HareObjectUtils;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 17:43
 */
public abstract class AbstractHareMemoryQueue<T> implements HareMemoryQueue<T> {

    public static final int UNLIMITED = -1;

    private final AtomicInteger maxSize = new AtomicInteger(UNLIMITED);

    private final AtomicReference<HareMemoryQueueOverflowPolicy> policy = new AtomicReference<>(new DefaultRejectOverflowPolicy());

    public AbstractHareMemoryQueue() {
        this(UNLIMITED);
    }

    public AbstractHareMemoryQueue(int maxSize) {
        this.setMaxSize(maxSize);
    }

    @Override
    public void batchOffer(List<T> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        for (T element : list) {
            offer(element);
        }
    }

    @Override
    public T poll() {
        return getFirst(batchPoll(1));
    }

    @Override
    public T poll(TimeUnit timeUnit, long timeOut) {
        return getFirst(batchPoll(1, timeUnit, timeOut));
    }

    @Override
    public List<T> batchPoll(int expectSize) {
        return batchPoll(expectSize, null, UNLIMITED);
    }

    @Override
    public T take() {
        return getFirst(batchTake(1));
    }

    private T getFirst(List<T> ts) {
        return HareFunctionUtils.apply(ts, e ->
                HareObjectUtils.ternary(() -> CollectionUtils.isEmpty(e) ? null : e.get(0))
        );
    }

    @Override
    public void setOverflowPolicy(HareMemoryQueueOverflowPolicy policy) {
        this.policy.set(policy);
    }

    @Override
    public void setMaxSize(int maxSize) {
        this.maxSize.set(maxSize);
    }

    @Override
    public int getMaxSize() {
        return maxSize.get();
    }

    boolean checkIfOverflow() {
        int maxSize = getMaxSize();
        return maxSize != UNLIMITED && maxSize <= size();
    }

    boolean handleOverflow(T element) {
        return policy.get().handle(this, element);
    }
}
