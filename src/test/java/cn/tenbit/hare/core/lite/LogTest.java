package cn.tenbit.hare.core.lite;

import cn.tenbit.hare.core.lite.util.HareLogUtils;
import org.junit.Test;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 16:35
 */
public class LogTest {

    @Test
    public void test() {
        HareLogUtils.trace("123");
        HareLogUtils.debug("123");
        HareLogUtils.info("123");
        HareLogUtils.warn("123");
        HareLogUtils.error("123");
    }
}
