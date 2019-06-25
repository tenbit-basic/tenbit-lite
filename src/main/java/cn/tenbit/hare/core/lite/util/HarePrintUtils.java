package cn.tenbit.hare.core.lite.util;

import cn.tenbit.hare.core.lite.constant.HareConsts;
import cn.tenbit.hare.core.lite.exception.HareException;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.io.File;
import java.io.IOException;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 15:10
 */
public class HarePrintUtils {

    public static void console(Object... objs) {
        Object obj = getOutput(objs);
        sout(obj);
    }

    public static void jsonConsole(Object... objs) {
        Object obj = getOutput(objs);
        sout(HareJsonUtils.toJsonString(obj));
    }

    public static void prettyJsonConsole(Object... objs) {
        Object obj = getOutput(objs);
        sout(HareJsonUtils.toJsonString(obj, SerializerFeature.PrettyFormat));
    }

    public static void jsonWithPrefixConsole(String prefix, Object... args) {
        StringBuilder sb = new StringBuilder()
                .append(prefix)
                .append(" --> ")
                .append(HareJsonUtils.toJsonString(getOutput(args)));
        sout(sb.toString());
    }

    public static void logConsole(Object... objs) {
        Object obj = getOutput(objs);
        soutWithTime(obj);
    }

    public static void jsonLogConsole(Object... objs) {
        Object obj = getOutput(objs);
        soutWithTime(HareJsonUtils.toJsonString(obj));
    }

    public static void prettyJsonLogConsole(Object... objs) {
        Object obj = getOutput(objs);
        soutWithTime(HareJsonUtils.toJsonString(obj, SerializerFeature.PrettyFormat));
    }

    public static void jsonWithPrefixLogConsole(String prefix, Object... args) {
        StringBuilder sb = new StringBuilder()
                .append(prefix)
                .append(" --> ")
                .append(HareJsonUtils.toJsonString(getOutput(args)));
        soutWithTime(sb.toString());
    }

    public static void stringFile(String path, String content) {
        byte[] bytes = HareObjectUtils.ternary(content == null, ArrayUtils.EMPTY_BYTE_ARRAY, content.getBytes());
        file(new File(path), bytes);
    }

    public static void file(File file, byte[] bytes) {
        try {
            FileUtils.writeByteArrayToFile(file, bytes);
        } catch (IOException e) {
            HareException.makeThrow(e);
        }
    }

    private static void soutWithTime(Object obj) {
        sout(HareTimeUtils.currentFormatTime() + HareConsts.SPACE + HareStringUtils.toNullableString(obj));
    }

    private static void sout(Object obj) {
        System.out.println(obj);
    }

    private static Object getOutput(Object[] objs) {
        if (objs == null) {
            return null;
        }
        return HareObjectUtils.ternary(objs.length == 1, objs[0], objs);
    }
}
