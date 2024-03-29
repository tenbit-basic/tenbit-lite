package cn.tenbit.hare.core.lite.log;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 14:47
 */
// @CommonsLog
public class HareCommonsLog implements HareLog {

    private org.apache.commons.logging.Log log;

    public HareCommonsLog() {
        this(HareCommonsLog.class);
    }

    public HareCommonsLog(Class clz) {
        log = org.apache.commons.logging.LogFactory.getLog(clz);
    }

    @Override
    public void trace(String msg) {
        log.trace(msg);
    }

    @Override
    public void trace(String msg, Throwable e) {
        log.trace(msg, e);
    }

    @Override
    public void debug(String msg) {
        log.debug(msg);
    }

    @Override
    public void debug(String msg, Throwable e) {
        log.debug(msg, e);
    }

    @Override
    public void info(String msg) {
        log.info(msg);
    }

    @Override
    public void info(String msg, Throwable e) {
        log.info(msg, e);
    }

    @Override
    public void warn(String msg) {
        log.warn(msg);
    }

    @Override
    public void warn(String msg, Throwable e) {
        log.warn(msg, e);
    }

    @Override
    public void error(String msg) {
        log.error(msg);
    }

    @Override
    public void error(String msg, Throwable e) {
        log.error(msg, e);
    }
}
