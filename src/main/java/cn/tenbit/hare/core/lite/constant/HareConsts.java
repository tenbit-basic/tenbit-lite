package cn.tenbit.hare.core.lite.constant;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 13:17
 */
public interface HareConsts {

    String EMPTY = StringUtils.EMPTY;

    String SPACE = StringUtils.SPACE;

    String NEW_LINE = System.getProperty("line.separator", "\n");

    String UNDER_SCORE = "_";

    String COMMA = ",";

    String SHAPE = "#";

    String PRINT_TIME_PATTERN = "[yyyy-MM-dd HH:mm:ss.SSS]";

    String SUPPRESS_WARNING_UNCHECKED = "unchecked";
    String SUPPRESS_WARNING_RAWTYPE = "rawtype";
    String SUPPRESS_WARNING_DEPRECATION = "deprecation";
}
