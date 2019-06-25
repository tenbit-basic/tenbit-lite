package cn.tenbit.hare.core.lite.util;

import cn.tenbit.hare.core.lite.json.HareJson;
import cn.tenbit.hare.core.lite.json.HareJsonFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 14:11
 */
public class HareJsonUtils {

    private static final HareJson HARE_JSON = HareJsonFactory.getJsoner();

    public static String toJsonString(Object obj) {
        return HARE_JSON.toJsonString(obj);
    }

    public static String toJsonString(Object obj, SerializerFeature... features) {
        return JSON.toJSONString(obj, features);
    }

    public static <T> T parseObject(String str, Class<T> clz) {
        return HARE_JSON.parseObject(str, clz);
    }

    public static JSONObject parseObject(String str) {
        return JSON.parseObject(str);
    }

    public static <T> List<T> parseArray(String str, Class<T> clz) {
        return JSON.parseArray(str, clz);
    }

    public static <T> JSONArray parseArray(String str) {
        return JSON.parseArray(str);
    }
}
