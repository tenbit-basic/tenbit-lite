package cn.tenbit.hare.core.lite.memqueue.policy;

import cn.tenbit.hare.core.lite.memqueue.HareMemoryQueue;
import cn.tenbit.hare.core.lite.util.HareLogUtils;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 17:14
 */
public class IgnoreOverflowPolicy implements HareMemoryQueueOverflowPolicy {

    @Override
    public boolean handle(HareMemoryQueue queue, Object element) {
        HareLogUtils.warn("queue size limit to max " + queue.getMaxSize() + ", ignore: " + element);
        return false;
    }
}
