package cn.tenbit.hare.core.lite.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 13:29
 */
public class HareException extends RuntimeException {
    private static final long serialVersionUID = 6969162625457656555L;

    //--------------------------------------------------------------------------------------//

    public static final int SYS = 1;
    public static final int BIZ = 2;
    public static final int OTR = 3;

    //--------------------------------------------------------------------------------------//

    @Setter
    @Getter
    private Integer code = SYS;

    //--------------------------------------------------------------------------------------//

    public HareException() {
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

    public HareException(Integer code) {
        this.setCode(code);
    }

    public HareException(Integer code, String message) {
        super(message);
        this.setCode(code);
    }

    public HareException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.setCode(code);
    }

    public HareException(Integer code, Throwable cause) {
        super(cause);
        this.setCode(code);
    }

    //--------------------------------------------------------------------------------------//

    public static void makeThrow() {
        throw of();
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

    public static void makeThrow(Integer code) {
        throw of(code);
    }

    public static void makeThrow(Integer code, String message) {
        throw of(code, message);
    }

    public static void makeThrow(Integer code, String message, Throwable cause) {
        throw of(code, message, cause);
    }

    public static void makeThrow(Integer code, Throwable cause) {
        throw of(code, cause);
    }

    //--------------------------------------------------------------------------------------//

    public static HareException of() {
        return new HareException();
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

    public static HareException of(Integer code) {
        return new HareException(code);
    }

    public static HareException of(Integer code, String message) {
        return new HareException(code, message);
    }

    public static HareException of(Integer code, String message, Throwable cause) {
        return new HareException(code, message, cause);
    }

    public static HareException of(Integer code, Throwable cause) {
        return new HareException(code, cause);
    }

    //--------------------------------------------------------------------------------------//
}
