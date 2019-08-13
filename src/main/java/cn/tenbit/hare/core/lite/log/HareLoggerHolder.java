package cn.tenbit.hare.core.lite.log;

import cn.tenbit.hare.core.lite.util.HareClassUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author bangquan.qian
 * @Date 2019-08-13 10:33
 */
public class HareLoggerHolder {

    private static final Map<String, HareLog> LOGS = new ConcurrentHashMap<>();

    private static final HareLog DEFAULT_LOG = HareLogFactory.getLogger();

    static {
        LOGS.put(HareLog.class.getCanonicalName(), DEFAULT_LOG);
        LOGS.put(HareCommonsLog.class.getCanonicalName(), DEFAULT_LOG);
    }

    public static HareLog getLog(String clz) {
        return clz == null ? DEFAULT_LOG : LOGS.get(clz);
    }

    public static boolean addLog(String clz) {
        if (clz == null || LOGS.get(clz) != null) {
            return false;
        }
        return LOGS.putIfAbsent(clz, HareLogFactory.getLogger(HareClassUtils.getClass(clz))) == null;
    }

    public static HareLog getAndAddLogIfAbsent(String clz) {
        addLog(clz);
        return getLog(clz);
    }
}
