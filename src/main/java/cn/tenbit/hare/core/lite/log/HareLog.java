package cn.tenbit.hare.core.lite.log;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 14:46
 */
public interface HareLog {

    void trace(String msg);

    void trace(String msg, Throwable e);

    void debug(String msg);

    void debug(String msg, Throwable e);

    void info(String msg);

    void info(String msg, Throwable e);

    void warn(String msg);

    void warn(String msg, Throwable e);

    void error(String msg);

    void error(String msg, Throwable e);
}
