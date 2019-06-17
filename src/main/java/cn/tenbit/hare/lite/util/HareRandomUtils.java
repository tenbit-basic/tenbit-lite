package cn.tenbit.hare.lite.util;

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
}
