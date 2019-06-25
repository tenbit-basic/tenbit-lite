package cn.tenbit.hare.core.lite.util;

import org.apache.commons.lang3.ObjectUtils;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 14:24
 */
public class HareObjectUtils {

    public static <T> T ternary(boolean r, T t, T d) {
        return r ? t : d;
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
