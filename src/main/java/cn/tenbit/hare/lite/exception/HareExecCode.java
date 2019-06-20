package cn.tenbit.hare.lite.exception;

import cn.tenbit.hare.lite.constant.HareConsts;
import cn.tenbit.hare.lite.support.HareExecCustomCode;
import cn.tenbit.hare.lite.util.HareClassUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author bangquan.qian
 * @Date 2019-06-12 16:09
 */
public class HareExecCode {

    public static final int CODE_SUCCESS = 0;
    public static final int CODE_FAILURE = 1;
    public static final int CODE_UNDEFINED = -1;

    private static final int SUFFIX_SUCCESS = CODE_SUCCESS;
    private static final int SUFFIX_FAILURE = CODE_FAILURE;

    //--------------------------------------------------------------------------------------------//

    private static final Map<Integer, HareExecCode> INSIDE_MAP = new HashMap<>();
    private static final Map<Integer, HareExecCode> MAP = new ConcurrentHashMap<>();

    private static final AtomicInteger INDEX = new AtomicInteger(100);

    //--------------------------------------------------------------------------------------------//

    public static final HareExecCode UNDEFINED = HareExecCode.ofCode(CODE_UNDEFINED, HareConsts.EMPTY);
    public static final HareExecCode SUCCESS = HareExecCode.ofCode(CODE_SUCCESS, "success");
    public static final HareExecCode FAILURE = HareExecCode.ofCode(CODE_FAILURE, "failure");

    //--------------------------------------------------------------------------------------------//

    static {
        addInside(UNDEFINED);
        addInside(SUCCESS);
        addInside(FAILURE);
    }

    static {
        HareClassUtils.loadClass(HareExecCustomCode.class);
    }

    private final int code;

    private final String msg;

    private HareExecCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void makeThrow() {
        makeThrow(this);
    }

    public RuntimeException newException() {
        return newException(this);
    }

    public static int size() {
        return MAP.size();
    }

    public static HareExecCode getExecCode(int code) {
        return MAP.get(code);
    }

    public static HareExecCode getExecCode(Integer code) {
        return code == null ? null : getExecCode(code.intValue());
    }

    public static void makeThrow(HareExecCode execCode) {
        throw newException(execCode);
    }

    public static RuntimeException newException(HareExecCode execCode) {
        return HareException.of(execCode);
    }

    private static HareExecCode addInside(HareExecCode execCode) {
        INSIDE_MAP.put(execCode.getCode(), execCode);
        add(execCode);
        return execCode;
    }

    private static HareExecCode add(HareExecCode execCode) {
        MAP.put(execCode.getCode(), execCode);
        return execCode;
    }

    private static int genNewCode(int suffix) {
        return INDEX.getAndIncrement() * 10 + suffix;
    }

    private static HareExecCode ofCode(int code, String msg) {
        return new HareExecCode(code, msg);
    }

    private static HareExecCode ofSuffix(int suffix, String msg) {
        return add(ofCode(genNewCode(suffix), msg));
    }

    public static HareExecCode newFailure(String msg) {
        return ofSuffix(SUFFIX_FAILURE, msg);
    }

    public static HareExecCode newSuccess(String msg) {
        return ofSuffix(SUFFIX_SUCCESS, msg);
    }
}
