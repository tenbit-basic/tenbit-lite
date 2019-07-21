package cn.tenbit.hare.core.lite.util;

import cn.tenbit.hare.core.lite.function.HareSupplier;
import org.apache.commons.lang3.ObjectUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 14:24
 */
public class HareObjectUtils {

    @Deprecated
    public static <T> T ternary(boolean r, T t, T d) {
        return r ? t : d;
    }

    public static <T> T ternary(HareSupplier<T> f) {
        return f.get();
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
        return ternary(() -> obj != null ? obj : HareClassUtils.newInstance(clz));
    }

    public static <T> T requireNonNull(T obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        return obj;
    }

    public static boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }

    public static int safeHashCode(Object o, int safe) {
        return o != null ? o.hashCode() : safe;
    }

    public static <T> int safeCompare(T a, T b, int safe, Comparator<? super T> c) {
        return (a == b) ? safe : c.compare(a, b);
    }

    public static String safeToString(Object o, String def) {
        return (o != null) ? o.toString() : def;
    }

    public static int safeUnboxing(Integer number, int safe) {
        return ternary(() -> number == null ? safe : number);
    }

    public static long safeUnboxing(Long number, int safe) {
        return ternary(() -> number == null ? safe : number);
    }

    public static BigDecimal safeSetScale(BigDecimal bd, int scale, RoundingMode mode) {
        return ternary(() -> bd == null ? bd : bd.setScale(scale, mode));
    }
}
