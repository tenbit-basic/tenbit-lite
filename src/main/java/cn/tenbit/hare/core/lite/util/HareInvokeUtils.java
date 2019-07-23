package cn.tenbit.hare.core.lite.util;

import cn.tenbit.hare.core.lite.exception.HareException;
import cn.tenbit.hare.core.lite.function.HareExecutor;

/**
 * @Author bangquan.qian
 * @Date 2019-06-26 16:07
 */
public class HareInvokeUtils {

    public static <T> T invoke(HareExecutor<T> f) {
        return invokeWithTurnRe(f);
    }

    public static <T> Long invokeWithRecordTime(HareExecutor<T> f) {
        Long start = HareTimeUtils.currentTimeMs();
        invokeWithTurnRe(f);
        Long end = HareTimeUtils.currentTimeMs();
        return end - start;
    }

    public static <T> T invokeWithSwallow(HareExecutor<T> f) {
        try {
            return f.execute();
        } catch (Throwable e) {
            HareLogUtils.error("invoke", e);
        }
        return null;
    }

    public static <T> T invokeWithTurnRe(HareExecutor<T> f) {
        try {
            return f.execute();
        } catch (RuntimeException e) {
            throw e;
        } catch (Throwable e) {
            throw HareException.of(e);
        }
    }

}
