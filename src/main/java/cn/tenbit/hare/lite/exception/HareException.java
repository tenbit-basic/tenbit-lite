package cn.tenbit.hare.lite.exception;

import cn.tenbit.hare.lite.constant.HareConsts;
import cn.tenbit.hare.lite.util.HareStringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author bangquan.qian
 * @Date 2019-06-12 16:00
 */
public class HareException extends RuntimeException {
    private static final long serialVersionUID = 567222995388441054L;

    private static final String BIZ_MSG_SPLIT = "###";

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

    public HareException(HareExecCode e, Throwable cause) {
        this(combineMessage(e.getMsg(), cause), cause);
        this.setCode(e.getCode());
    }

    public int getCode() {
        return code;
    }

    private void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        String message = super.getMessage();
        if (StringUtils.isBlank(message)) {
            return message;
        }
        return message.replaceAll(BIZ_MSG_SPLIT, HareConsts.EMPTY);
    }

    public String getBizMsg() {
        String message = super.getMessage();
        if (StringUtils.isBlank(message)) {
            return message;
        }
        String[] splits = message.split(BIZ_MSG_SPLIT);
        if (ArrayUtils.isEmpty(splits) || splits.length < 2) {
            return message;
        }
        return HareStringUtils.trim(splits[0]);
    }

    public String getCauseMsg() {
        String message = super.getMessage();
        if (StringUtils.isBlank(message)) {
            return message;
        }
        String[] splits = message.split(BIZ_MSG_SPLIT);
        if (ArrayUtils.isEmpty(splits) || splits.length < 2) {
            return message;
        }
        return HareStringUtils.trim(splits[1]);
    }

    private static String combineMessage(String execCodeMsg, Throwable cause) {
        String causeMsg = HareStringUtils.toNotNullString(cause.getMessage());

        execCodeMsg = HareStringUtils.trim(HareStringUtils.toNotNullString(execCodeMsg));
        execCodeMsg = StringUtils.isNotEmpty(execCodeMsg) ? execCodeMsg + HareConsts.SPACE : execCodeMsg;

        return execCodeMsg + BIZ_MSG_SPLIT + causeMsg;
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

    public static HareException of(HareExecCode e, Throwable cause) {
        return new HareException(e, cause);
    }

    public static HareException of(int code, String msg) {
        return new HareException(code, msg);
    }
}
