package cn.tenbit.hare.core.lite.util;

import cn.tenbit.hare.core.lite.constant.HareConsts;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 14:20
 */
public class HareStringUtils {

    public static String toNullableString(Object str) {
        return HareObjectUtils.ternary(str == null, null, String.valueOf(str));
    }

    public static String toNotNullString(Object str) {
        return HareObjectUtils.ternary(str == null, HareConsts.EMPTY, String.valueOf(str));
    }

    public static String nullIfBlank(String str) {
        return HareObjectUtils.ternary(StringUtils.isBlank(str), null, str);
    }

    public static String nullIfEmpty(String str) {
        return HareObjectUtils.ternary(StringUtils.isEmpty(str), null, str);
    }
}
