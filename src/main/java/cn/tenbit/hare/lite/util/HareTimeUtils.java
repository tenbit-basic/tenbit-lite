package cn.tenbit.hare.lite.util;

import cn.tenbit.hare.lite.constant.HareConsts;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @Author bangquan.qian
 * @Date 2019-06-14 15:46
 */
public class HareTimeUtils {

    private static final DateTimeFormatter formatter = DateTimeFormat.forPattern(HareConsts.PRINT_DATE_PATTERN);

    public static String currentTimeMillisString() {
        return formatter.print(currentTimeMillis());
    }

    public static Long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
