package cn.tenbit.hare.core.lite.exception;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 15:23
 */
public class HareExceptions {

    public static final HareExceptionOperations FAILURE = ofSys("failure");

    public static final HareExceptionOperations UNSUPPORTED = ofSys("unsupported");

    public static HareExceptionOperations ofBiz(String msg) {
        return forOperation(HareException.of(HareException.BIZ, msg));
    }

    public static HareExceptionOperations ofBiz(Throwable e) {
        return forOperation(HareException.of(HareException.BIZ, e));
    }

    public static HareExceptionOperations ofBiz(String msg, Throwable e) {
        return forOperation(HareException.of(HareException.BIZ, msg, e));
    }

    public static HareExceptionOperations ofSys(String msg) {
        return forOperation(HareException.of(HareException.SYS, msg));
    }

    public static HareExceptionOperations ofSys(Throwable e) {
        return forOperation(HareException.of(HareException.SYS, e));
    }

    public static HareExceptionOperations ofSys(String msg, Throwable e) {
        return forOperation(HareException.of(HareException.SYS, msg, e));
    }

    public static HareExceptionOperations forOperation(HareException exception) {
        return new HareExceptionOperations(exception);
    }
}
