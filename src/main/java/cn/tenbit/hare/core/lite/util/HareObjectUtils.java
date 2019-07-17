package cn.tenbit.hare.core.lite.util;

import cn.tenbit.hare.core.lite.function.HareSupplier;
import org.apache.commons.lang3.ObjectUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
