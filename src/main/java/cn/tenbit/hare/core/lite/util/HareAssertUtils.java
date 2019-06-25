package cn.tenbit.hare.core.lite.util;

import cn.tenbit.hare.core.lite.exception.HareException;

/**
 * @Author bangquan.qian
 * @Date 2019-06-12 16:13
 */
public class HareAssertUtils {

    public static void notNull(Object o) {
        if (o == null) {
            HareException.makeThrow("is null");
        }
    }

    public static void notNull(Object o, String m) {
        if (o == null) {
            HareException.makeThrow(m);
        }
    }

    public static void isTrue(boolean r) {
        if (!r) {
            HareException.makeThrow("not true");
        }
    }

    public static void isTrue(boolean r, String m) {
        if (!r) {
            HareException.makeThrow(m);
        }
    }

    public static void isFalse(boolean r) {
        if (r) {
            HareException.makeThrow("not false");
        }
    }

    public static void isFalse(boolean r, String m) {
        if (r) {
            HareException.makeThrow(m);
        }
    }
}
