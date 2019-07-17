package cn.tenbit.hare.core.lite.util;

import cn.tenbit.hare.core.lite.common.bool.HareBoolEnums;
import cn.tenbit.hare.core.lite.exception.HareExceptions;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author bangquan.qian
 * @Date 2019-07-17 16:22
 */
public class HareBoolUtils {

    public static Boolean toBoolean(Integer val) {
        return val == null ? null : getBool(val).getBoolVal();
    }

    public static Integer toInteger(Boolean val) {
        return val == null ? null : getBool(val).getIntVal();
    }

    public static boolean toBool(Integer val) {
        return getBool(val).getBoolVal();
    }

    public static int toInt(Boolean val) {
        return getBool(val).getIntVal();
    }

    public static boolean toBool(int val) {
        return getBool(val).getBoolVal();
    }

    public static int toInt(boolean val) {
        return getBool(val).getIntVal();
    }

    public static HareBoolEnums getBool(Boolean val) {
        HareAssertUtils.notNull(val);
        return getBool(val.booleanValue());
    }

    public static HareBoolEnums getBool(Integer val) {
        HareAssertUtils.notNull(val);
        return getBool(val.intValue());
    }

    public static HareBoolEnums getBool(boolean val) {
        return val ? getTrue() : getFalse();
    }

    public static HareBoolEnums getBool(int val) {
        if (val == getTrue().getIntVal()) {
            return getTrue();
        }
        if (val == getFalse().getIntVal()) {
            return getFalse();
        }
        throw HareExceptions.UNSUPPORTED.newOne();
    }

    public static HareBoolEnums getBoolByChinese(String val) {
        String trim = StringUtils.trim(val);
        if (getTrue().getChineseVal().equals(trim)) {
            return getTrue();
        }
        if (getFalse().getChineseVal().equals(trim)) {
            return getFalse();
        }
        throw HareExceptions.UNSUPPORTED.newOne();
    }

    public static HareBoolEnums getBoolByEnglish(String val) {
        String trim = StringUtils.trim(val);
        if (getTrue().getEnglishVal().equals(trim)) {
            return getTrue();
        }
        if (getFalse().getEnglishVal().equals(trim)) {
            return getFalse();
        }
        throw HareExceptions.UNSUPPORTED.newOne();
    }

    public static HareBoolEnums getFalse() {
        return HareBoolEnums.FALSE;
    }

    public static HareBoolEnums getTrue() {
        return HareBoolEnums.TRUE;
    }
}
