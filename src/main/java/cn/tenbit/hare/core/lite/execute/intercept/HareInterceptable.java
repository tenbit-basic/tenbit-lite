package cn.tenbit.hare.core.lite.execute.intercept;

/**
 * @Author bangquan.qian
 * @Date 2019-06-20 10:19
 */
@FunctionalInterface
public interface HareInterceptable<T> {

    T intercept(T target) throws Exception;
}
