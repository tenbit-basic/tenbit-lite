package cn.tenbit.hare.lite.util;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.logging.Log;

/**
 * @Author bangquan.qian
 * @Date 2019-06-14 11:59
 */
@CommonsLog
public class HareLogUtils {

    public static Log getLogger() {
        return log;
    }

    public static void trace(String s) {
        log.trace(s);
    }

    public static void trace(String s, Throwable t) {
        log.trace(s, t);
    }

    public static void debug(String s) {
        log.debug(s);
    }

    public static void debug(String s, Throwable t) {
        log.debug(s, t);
    }

    public static void info(String s) {
        log.info(s);
    }

    public static void info(String s, Throwable t) {
        log.info(s, t);
    }

    public static void warn(String s) {
        log.warn(s);
    }

    public static void warn(String s, Throwable t) {
        log.warn(s, t);
    }

    public static void error(String s) {
        log.error(s);
    }

    public static void error(String s, Throwable t) {
        log.error(s, t);
    }
}
