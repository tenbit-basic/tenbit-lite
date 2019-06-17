package cn.tenbit.hare.lite.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;

/**
 * @Author bangquan.qian
 * @Date 2019-06-13 17:57
 */
public class HareJsonUtils {


    public static String toJsonString(Object obj) {
        return JSON.toJSONString(obj);
    }

    public static <T> T parseJavaObject(String str, Class<T> clz) {
        return JSON.parseObject(str, clz);
    }

    public static <T> List<T> parseJavaArray(String str, Class<T> clz) {
        return JSON.parseArray(str, clz);
    }

    public static String toJsonString(Object obj, SerializerFeature... features) {
        return JSON.toJSONString(obj, features);
    }
}
