package cn.tenbit.hare.core.lite.json;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 14:08
 */
public interface HareJson {

    String toJsonString(Object obj);

    <T> T parseObject(String str, Class<T> clz);
}
