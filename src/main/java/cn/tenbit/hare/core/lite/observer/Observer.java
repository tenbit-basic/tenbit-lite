package cn.tenbit.hare.core.lite.observer;

/**
 * @Author bangquan.qian
 * @Date 2019-07-21 13:55
 */
public interface Observer extends Comparable {

    void update(Observable observable, Object arg);
}
