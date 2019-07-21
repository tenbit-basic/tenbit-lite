package cn.tenbit.hare.core.lite.observer;

/**
 * @Author bangquan.qian
 * @Date 2019-07-21 13:55
 */
public interface HareObserver extends Comparable {

    void update(HareObservable observable, Object arg);
}
