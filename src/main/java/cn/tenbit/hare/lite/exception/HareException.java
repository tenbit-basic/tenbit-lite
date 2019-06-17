package cn.tenbit.hare.lite.exception;

/**
 * @Author bangquan.qian
 * @Date 2019-06-12 16:00
 */
public class HareException extends RuntimeException {
    private static final long serialVersionUID = 567222995388441054L;

    private int code = HareExecCode.UNDEFINED.getCode();

    public HareException() {
        super();
    }

    public HareException(String message) {
        super(message);
    }

    public HareException(String message, Throwable cause) {
        super(message, cause);
    }

    public HareException(Throwable cause) {
        super(cause);
    }

    public HareException(HareExecCode e) {
        this(e.getCode(), e.getMsg());
    }

    public HareException(int code, String msg) {
        this(msg);
        this.setCode(code);
    }

    public int getCode() {
        return code;
    }

    private void setCode(int code) {
        this.code = code;
    }

    public HareExecCode getExecCode() {
        return HareExecCode.getExecCode(this.code);
    }

    public static void makeThrow(String message) {
        throw of(message);
    }

    public static void makeThrow(String message, Throwable cause) {
        throw of(message, cause);
    }

    public static void makeThrow(Throwable cause) {
        throw of(cause);
    }

    public static void makeThrow(HareExecCode e) {
        throw of(e);
    }

    public static void makeThrow(int code, String msg) {
        throw of(code, msg);
    }

    public static HareException of(String message) {
        return new HareException(message);
    }

    public static HareException of(String message, Throwable cause) {
        return new HareException(message, cause);
    }

    public static HareException of(Throwable cause) {
        return new HareException(cause);
    }

    public static HareException of(HareExecCode e) {
        return new HareException(e);
    }

    public static HareException of(int code, String msg) {
        return new HareException(code, msg);
    }
}
