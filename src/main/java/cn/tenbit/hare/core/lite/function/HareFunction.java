package cn.tenbit.hare.core.lite.function;

/**
 * @Author bangquan.qian
 * @Date 2019-06-12 18:40
 */
@FunctionalInterface
public interface HareFunction<T, R> {

    R apply(T t);
}
