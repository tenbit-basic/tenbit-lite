package cn.tenbit.hare.core.lite.util;

import java.util.UUID;

/**
 * @Author bangquan.qian
 * @Date 2019-06-14 15:22
 */
public class HareRandomUtils {

    public static int randomInt(int min, int max) {
        HareAssertUtils.isTrue(min <= max);
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static int randomRangeInt(int original, int minus, int plus) {
        return original + randomInt(minus, plus);
    }

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static int[] randomIntArray(int size, int min, int max) {
        HareAssertUtils.isTrue(size > 0 && max - min + 1 >= size);
        int[] arr = new int[size];
        for (int idx = 0; idx < size; idx++) {
            int rand = randomInt(min, max);
            boolean contains = false;
            for (int jdx = 0; jdx < idx; jdx++) {
                if (arr[jdx] == rand) {
                    contains = true;
                    break;
                }
            }
            if (contains) {
                idx--;
                continue;
            }
            arr[idx] = rand;
        }
        return arr;
    }
}
