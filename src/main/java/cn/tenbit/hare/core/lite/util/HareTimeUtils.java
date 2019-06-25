package cn.tenbit.hare.core.lite.util;

import cn.tenbit.hare.core.lite.constant.HareConsts;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 14:18
 */
public class HareTimeUtils {

    private static final DateTimeFormatter FORMATTER = DateTimeFormat.forPattern(HareConsts.PRINT_TIME_PATTERN);

    public static String currentTimeMsStr() {
        return HareStringUtils.toNotNullString(currentTimeMs());
    }

    public static Long currentTimeMs() {
        return System.currentTimeMillis();
    }

    public static String currentFormatTime() {
        return FORMATTER.print(currentTimeMs());
    }

}
