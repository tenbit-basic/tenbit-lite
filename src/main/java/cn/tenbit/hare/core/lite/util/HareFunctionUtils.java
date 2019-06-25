package cn.tenbit.hare.core.lite.util;

import cn.tenbit.hare.core.lite.function.HareConsumer;
import cn.tenbit.hare.core.lite.function.HareFunction;
import cn.tenbit.hare.core.lite.function.HarePredictor;
import cn.tenbit.hare.core.lite.function.HareSupplier;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 17:53
 */
public class HareFunctionUtils {

    public static <T> void accept(T t, HareConsumer<T> f) {
        f.accept(t);
    }

    public static <T, R> R apply(T t, HareFunction<T, R> f) {
        return f.apply(t);
    }

    public static <T> boolean test(T t, HarePredictor<T> f) {
        return f.test(t);
    }

    public static <T> T test(HareSupplier<T> f) {
        return f.get();
    }
}
