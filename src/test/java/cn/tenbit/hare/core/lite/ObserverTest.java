package cn.tenbit.hare.core.lite;

import cn.tenbit.hare.core.lite.observer.HareObservable;
import cn.tenbit.hare.core.lite.observer.HareObserver;
import cn.tenbit.hare.core.lite.util.HareAssertUtils;
import cn.tenbit.hare.core.lite.util.HarePrintUtils;
import org.junit.Test;

/**
 * @Author bangquan.qian
 * @Date 2019-07-21 14:16
 */
public class ObserverTest {

    @Test
    public void test() {
        HareObserver observer1 = new HareObserver() {

            @Override
            public void update(HareObservable observable, Object arg) {
                HarePrintUtils.console("observer1 received");
            }

            @Override
            public int compareTo(Object o) {
                HareAssertUtils.notNull(o);
                return this.hashCode() - o.hashCode();
            }
        };

        HareObserver observer2 = new HareObserver() {

            @Override
            public void update(HareObservable observable, Object arg) {
                HarePrintUtils.console("observer2 received");
            }

            @Override
            public int compareTo(Object o) {
                HareAssertUtils.notNull(o);
                return this.hashCode() - o.hashCode();
            }
        };


        HareObservable observable = new HareObservable();
        observable.addObserver(observer1);
        observable.addObserver(observer2);

        observable.notifyObservers();
    }
}
