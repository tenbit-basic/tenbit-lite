package cn.tenbit.hare.core.lite.observer;

import cn.tenbit.hare.core.lite.util.HareAssertUtils;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author bangquan.qian
 * @Date 2019-07-21 14:01
 */
public class HareObservable {

    private final AtomicBoolean changed = new AtomicBoolean(false);

    private final ConcurrentSkipListSet<HareObserver> observers = new ConcurrentSkipListSet<>();

    private final AtomicInteger count = new AtomicInteger(0);

    private final Object lock = new Object();

    public synchronized void addObserver(HareObserver o) {
        HareAssertUtils.notNull(o);
        if (observers.add(o)) {
            count.incrementAndGet();
        }
    }

    public synchronized void removeObserver(HareObserver o) {
        HareAssertUtils.notNull(o);
        if (observers.remove(o)) {
            count.decrementAndGet();
        }
    }

    public void notifyObservers() {
        notifyObservers(null);
    }

    public void notifyObservers(Object arg) {
        if (hasChanged()) {
            return;
        }

        synchronized (lock) {
            if (hasChanged()) {
                return;
            }
            try {
                setChanged();

                List<HareObserver> os = new ArrayList<>(observers);
                if (CollectionUtils.isEmpty(os)) {
                    return;
                }

                for (HareObserver o : os) {
                    o.update(this, arg);
                }
            } finally {
                clearChanged();
            }
        }
    }

    public void clearObservers() {
        observers.clear();
        count.getAndSet(0);
    }

    private void setChanged() {
        changed.getAndSet(true);
    }

    private void clearChanged() {
        changed.getAndSet(false);
    }

    public boolean hasChanged() {
        return changed.get();
    }

    public int countObservers() {
        return count.get();
    }
}
