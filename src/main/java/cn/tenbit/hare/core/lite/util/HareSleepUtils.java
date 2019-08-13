package cn.tenbit.hare.core.lite.util;

import java.util.concurrent.TimeUnit;

/**
 * @Author bangquan.qian
 * @Date 2019-04-17 15:50
 */
public class HareSleepUtils {

    public static void randomSleepSeconds(int seconds, int minus, int plus) {
        sleepSeconds(HareRandomUtils.randomRangeInt(seconds, minus, plus));
    }

    public static void sleepSeconds(int seconds) {
        sleep(TimeUnit.SECONDS, seconds);
    }

    public static void sleep(TimeUnit unit, long time) {
        HareInvokeUtils.invokeWithTurnRe(() -> {
            unit.sleep(time);
            return null;
        });
    }
}
