package cn.tenbit.hare.core.lite.json;

import com.alibaba.fastjson.JSON;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 14:10
 */
public class HareFastJson implements HareJson {

    @Override
    public String toJsonString(Object obj) {
        return JSON.toJSONString(obj);
    }

    @Override
    public <T> T parseObject(String str, Class<T> clz) {
        return JSON.parseObject(str, clz);
    }
}
