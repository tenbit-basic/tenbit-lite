package cn.tenbit.hare.core.lite.json;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 14:10
 */
public class HareJsonFactory {

    public static HareJson getJsoner() {
        return new HareFastJson();
    }
}
