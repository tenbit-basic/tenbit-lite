package cn.tenbit.hare.core.lite.util;

import cn.tenbit.hare.core.lite.constant.HareConsts;
import cn.tenbit.hare.core.lite.exception.HareException;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author bangquan.qian
 * @Date 2019-05-14 16:14
 */

public class HarePropertiesUtils {

    private static final String CLASS_PATH_PREFIX = "classpath:";

    public static Properties loadFromPropertiesFile(String path) {
        HareAssertUtils.isTrue(StringUtils.isNoneBlank(path), "path invalid");
        path = StringUtils.trim(path);
        if (path.startsWith(CLASS_PATH_PREFIX)) {
            path = StringUtils.trim(path.substring(CLASS_PATH_PREFIX.length()));
        }
        InputStream is = HareClassUtils.getResourceAsStream(path);
        return load(is);
    }

    public static Properties load(InputStream is) {
        HareAssertUtils.notNull(is, "stream is null");
        Properties prop = new Properties();
        try {
            prop.load(is);
        } catch (Exception e) {
            throw HareException.of("load");
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                throw HareException.of("close");
            }
        }
        return prop;
    }

    public static String getNotNullProperty(Properties prop, String key) {
        String property = prop.getProperty(key);
        return HareObjectUtils.ternary(StringUtils.isBlank(property), HareConsts.EMPTY, StringUtils.trim(property));
    }
}
