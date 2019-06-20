package cn.tenbit.hare.lite.util;

import org.apache.commons.lang3.ObjectUtils;

/**
 * @Author bangquan.qian
 * @Date 2019-06-12 16:54
 */
public class HareObjectUtils {

    /**
     * 三目运算符
     */
    public static <T> T ternary(boolean r, T e, T t) {
        return r ? e : t;
    }

    public static <T> T defaultIfNull(T t, T d) {
        return ObjectUtils.defaultIfNull(t, d);
    }

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }

    public static <T> T newIfNull(T obj, Class<T> clz) {
        return ternary(obj != null, obj, HareClassUtils.newInstance(clz));
    }
}
