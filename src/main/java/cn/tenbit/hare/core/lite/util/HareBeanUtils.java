package cn.tenbit.hare.core.lite.util;

import cn.tenbit.hare.core.lite.constant.HareConsts;
import cn.tenbit.hare.core.lite.exception.HareException;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

/**
 * @Author bangquan.qian
 * @Date 2019-06-14 16:32
 */
public class HareBeanUtils {

    private static final String PREFIX_GETTER = "get";
    private static final String PREFIX_SETTER = "set";

    public static Method getGetterMethod(Class clz, Field field) {
        return getGetterMethod(clz, field.getName());
    }

    public static Method getGetterMethod(Class clz, String fieldName) {
        return getGsetMethod(clz, PREFIX_GETTER, fieldName);
    }

    public static Method getSetterMethod(Class clz, Field field) {
        return getSetterMethod(clz, field.getName());
    }

    public static Method getSetterMethod(Class clz, String fieldName) {
        return getGsetMethod(clz, PREFIX_SETTER, fieldName);
    }

    private static Method getGsetMethod(Class clz, String prefix, String fieldName) {
        try {
            return ClassUtils.getPublicMethod(clz, getGsetMethodName(prefix, fieldName));
        } catch (NoSuchMethodException e) {
            throw HareException.of(e);
        }
    }

    private static String getGsetMethodName(String prefix, String fieldName) {
        HareAssertUtils.isTrue(StringUtils.isNoneBlank(fieldName), "field name invalid");
        fieldName = StringUtils.trim(fieldName);
        String firstPart = fieldName.substring(0, 1).toUpperCase();
        final String finalFieldName = fieldName;
        String secondPart = HareObjectUtils.ternary(() -> finalFieldName.length() < 2 ? HareConsts.EMPTY : finalFieldName.substring(1));
        return prefix + firstPart + secondPart;
    }

    /**
     * 对象浅拷贝
     */
    public static <S, T> T copyObject(S s, Class<T> clz, String... ignoreProperties) {
        return HareCopyUtils.copyObject(s, clz, ignoreProperties);
    }

    /**
     * list浅拷贝
     */
    public static <S, T> List<T> copyList(Collection<S> srcs, Class<T> clz, String... ignoreProperties) {
        return HareCopyUtils.copyList(srcs, clz, ignoreProperties);
    }
}
