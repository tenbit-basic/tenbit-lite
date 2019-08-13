package cn.tenbit.hare.core.lite.log;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 14:47
 */
public class HareLogFactory {

    public static HareLog getLogger() {
        return new HareCommonsLog();
    }

    public static HareLog getLogger(Class clz) {
        return new HareCommonsLog(clz);
    }
}
