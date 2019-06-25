package cn.tenbit.hare.core.lite.execute.chain;

/**
 * @Author bangquan.qian
 * @Date 2019-04-15 23:44
 */
@FunctionalInterface
public interface HareOnCatchExecutable<T> {

    void execute(T target, Throwable e);
}
