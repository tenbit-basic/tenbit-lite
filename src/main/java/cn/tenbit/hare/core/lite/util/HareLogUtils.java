package cn.tenbit.hare.core.lite.util;

import cn.tenbit.hare.core.lite.log.HareLog;
import cn.tenbit.hare.core.lite.log.HareLoggerHolder;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 14:45
 */
public class HareLogUtils {

    private static final int STACK_LEVEL = 4;

    public static void trace(String msg) {
        getLog().trace(msg);
    }

    public static void trace(String msg, Throwable e) {
        getLog().trace(msg, e);
    }

    public static void debug(String msg) {
        getLog().debug(msg);
    }

    public static void debug(String msg, Throwable e) {
        getLog().debug(msg, e);
    }

    public static void info(String msg) {
        getLog().info(msg);
    }

    public static void info(String msg, Throwable e) {
        getLog().info(msg, e);
    }

    public static void warn(String msg) {
        getLog().warn(msg);
    }

    public static void warn(String msg, Throwable e) {
        getLog().warn(msg, e);
    }

    public static void error(String msg) {
        getLog().error(msg);
    }

    public static void error(String msg, Throwable e) {
        getLog().error(msg, e);
    }

    private static HareLog getLog() {
        return HareLoggerHolder.getAndAddLogIfAbsent(getCallerClassName());
    }

    private static String getCallerClassName() {
        Thread thread = Thread.currentThread();
        if (thread == null) {
            return null;
        }
        StackTraceElement[] trace = thread.getStackTrace();
        if (trace == null || trace.length <= STACK_LEVEL) {
            return null;
        }
        return trace[STACK_LEVEL].getClassName();
    }
}
