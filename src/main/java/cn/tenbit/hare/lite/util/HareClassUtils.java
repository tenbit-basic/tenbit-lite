package cn.tenbit.hare.lite.util;

import cn.tenbit.hare.lite.exception.HareException;

import java.io.InputStream;

/**
 * @Author bangquan.qian
 * @Date 2019-06-13 18:39
 */
public class HareClassUtils {

    private static final Class CURRENT_CLASS = HareClassUtils.class;

    public static <T> Class<T> loadClass(Class<T> clz) {
        return clz;
    }

    public static InputStream getResourceAsStream(String name) {
        return CURRENT_CLASS.getResourceAsStream(name);
    }

    public static <T> T newInstance(Class<T> clz) {
        try {
            return clz.newInstance();
        } catch (Exception e) {
            throw HareException.of(e);
        }
    }
}
