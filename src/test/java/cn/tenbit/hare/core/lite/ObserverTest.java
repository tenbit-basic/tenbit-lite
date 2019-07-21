package cn.tenbit.hare.core.lite;

import cn.tenbit.hare.core.lite.observer.Observable;
import cn.tenbit.hare.core.lite.observer.Observer;
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
        Observer observer1 = new Observer() {

            @Override
            public void update(Observable observable, Object arg) {
                HarePrintUtils.console("observer1 received");
            }

            @Override
            public int compareTo(Object o) {
                HareAssertUtils.notNull(o);
                return this.hashCode() - o.hashCode();
            }
        };

        Observer observer2 = new Observer() {

            @Override
            public void update(Observable observable, Object arg) {
                HarePrintUtils.console("observer2 received");
            }

            @Override
            public int compareTo(Object o) {
                HareAssertUtils.notNull(o);
                return this.hashCode() - o.hashCode();
            }
        };


        Observable observable = new Observable();
        observable.addObserver(observer1);
        observable.addObserver(observer2);

        observable.notifyObservers();
    }
}
