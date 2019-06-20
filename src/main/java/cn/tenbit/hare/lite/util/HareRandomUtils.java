package cn.tenbit.hare.lite.util;

import java.util.UUID;

/**
 * @Author bangquan.qian
 * @Date 2019-06-14 15:22
 */
public class HareRandomUtils {

    public static int randomRangeInt(int original, int minus, int plus) {
        HareAssertUtils.isTrue(minus <= plus, "minus > plus");
        int result = (int) (Math.random() * (plus - minus + 1)) + minus;
        return original + result;
    }

    public static String uuid() {
        return UUID.randomUUID().toString();
    }
}
