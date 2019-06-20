package cn.tenbit.hare.lite.util;

import cn.tenbit.hare.lite.constant.HareConsts;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author bangquan.qian
 * @Date 2018-12-15 00:35
 */

public class HareStringUtils {

    public static String toNotNullString(Object obj) {
        return HareObjectUtils.ternary(obj == null, HareConsts.EMPTY, String.valueOf(obj));
    }

    public static String toNullableString(Object obj) {
        return HareObjectUtils.ternary(obj == null, null, String.valueOf(obj));
    }

    public static String toJsonString(Object obj) {
        return HareJsonUtils.toJsonString(obj);
    }

    public static String toJsonString(Object obj, SerializerFeature... features) {
        return HareJsonUtils.toJsonString(obj, features);
    }

    public static String nullIfBlank(String str) {
        return HareObjectUtils.ternary(StringUtils.isBlank(str), null, str);
    }

    public static String nullIfEmpty(String str) {
        return HareObjectUtils.ternary(StringUtils.isEmpty(str), null, str);
    }

    public static String trim(String str) {
        return StringUtils.trim(str);
    }
}
