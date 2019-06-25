package cn.tenbit.hare.core.lite.structure.memqueue;

import cn.tenbit.hare.core.lite.structure.memqueue.policy.HareMemoryQueueOverflowPolicy;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 17:03
 */
public interface HareMemoryQueue<T> {

    void setMaxSize(int maxSize);

    int getMaxSize();

    int size();

    void setOverflowPolicy(HareMemoryQueueOverflowPolicy policy);

    void batchOffer(List<T> list);

    boolean offer(T element);

    List<T> batchPoll(int expectSize);

    T poll();

    List<T> batchPoll(int expectSize, TimeUnit timeUnit, long timeOut);

    T poll(TimeUnit timeUnit, long timeOut);

    List<T> batchTake(int expectSize);

    T take();

    List<T> smartPoll(int expectSize);
}
