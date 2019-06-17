package cn.tenbit.hare.lite.constant;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author bangquan.qian
 * @Date 2019-06-13 16:26
 */
public interface HareConsts {

    String PRINT_DATE_PATTERN = "[yyyy/MM/dd HH:mm:ss]";

    String EMPTY = StringUtils.EMPTY;

    String SPACE = StringUtils.SPACE;

    String NL = System.getProperty("line.separator", "\n");

    String UL = "_";

    String SUPPRESS_WARNING_UNCHECKED = "unchecked";
    String SUPPRESS_WARNING_RAWTYPE = "rawtype";
    String SUPPRESS_WARNING_DEPRECATION = "deprecation";
}
