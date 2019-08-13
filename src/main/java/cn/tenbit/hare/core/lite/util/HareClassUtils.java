package cn.tenbit.hare.core.lite.util;

import org.apache.commons.lang3.ClassUtils;

import java.io.InputStream;

/**
 * @Author bangquan.qian
 * @Date 2019-06-13 18:39
 */
public class HareClassUtils {

    private static final Class CURRENT_CLASS = HareClassUtils.class;

    public static Class getClass(String name) {
        return HareInvokeUtils.invokeWithTurnRe(() -> {
            return ClassUtils.getClass(name);
        });
    }

    public static <T> Class<T> loadClass(Class<T> clz) {
        return clz;
    }

    public static InputStream getResourceAsStream(String name) {
        return CURRENT_CLASS.getResourceAsStream(name);
    }

    public static <T> T newInstance(Class<T> clz) {
        return HareInvokeUtils.invokeWithTurnRe(() -> {
            return clz.newInstance();
        });
    }
}
