package cn.tenbit.hare.core.lite.util;

import cn.tenbit.hare.core.lite.log.HareLog;
import cn.tenbit.hare.core.lite.log.HareLogFactory;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 14:45
 */
public class HareLogUtils {

    private static final HareLog HARE_LOG = HareLogFactory.getLogger();

    public static void trace(String msg) {
        HARE_LOG.trace(msg);
    }

    public static void trace(String msg, Throwable e) {
        HARE_LOG.trace(msg, e);
    }

    public static void debug(String msg) {
        HARE_LOG.debug(msg);
    }

    public static void debug(String msg, Throwable e) {
        HARE_LOG.debug(msg, e);
    }

    public static void info(String msg) {
        HARE_LOG.info(msg);
    }

    public static void info(String msg, Throwable e) {
        HARE_LOG.info(msg, e);
    }

    public static void warn(String msg) {
        HARE_LOG.warn(msg);
    }

    public static void warn(String msg, Throwable e) {
        HARE_LOG.warn(msg, e);
    }

    public static void error(String msg) {
        HARE_LOG.error(msg);
    }

    public static void error(String msg, Throwable e) {
        HARE_LOG.error(msg, e);
    }
}
