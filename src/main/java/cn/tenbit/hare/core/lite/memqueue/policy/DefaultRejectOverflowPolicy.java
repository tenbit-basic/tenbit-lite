package cn.tenbit.hare.core.lite.memqueue.policy;

import cn.tenbit.hare.core.lite.exception.HareExceptions;
import cn.tenbit.hare.core.lite.memqueue.HareMemoryQueue;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 17:14
 */
public class DefaultRejectOverflowPolicy implements HareMemoryQueueOverflowPolicy {

    @Override
    public boolean handle(HareMemoryQueue queue, Object element) {
        throw HareExceptions.ofSys("queue size limit to max " + queue.getMaxSize()).newOne();
    }
}
