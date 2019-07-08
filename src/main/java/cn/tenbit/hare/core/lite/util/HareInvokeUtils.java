package cn.tenbit.hare.core.lite.util;

import cn.tenbit.hare.core.lite.exception.HareException;
import cn.tenbit.hare.core.lite.function.HareExecutor;

/**
 * @Author bangquan.qian
 * @Date 2019-06-26 16:07
 */
public class HareInvokeUtils {

    public static void invoke(HareExecutor f) {
        f.execute();
    }

    public static Long invokeWithRecordTime(HareExecutor f) {
        Long start = HareTimeUtils.currentTimeMs();
        f.execute();
        Long end = HareTimeUtils.currentTimeMs();
        return end - start;
    }

    public static void invokeWithSwallow(HareExecutor f) {
        try {
            f.execute();
        } catch (Throwable e) {
            HareLogUtils.error("invoke", e);
        }
    }

    public static void invokeWithTurnRe(HareExecutor f) {
        try {
            f.execute();
        } catch (RuntimeException e) {
            throw e;
        } catch (Throwable e) {
            throw HareException.of(e);
        }
    }

}
