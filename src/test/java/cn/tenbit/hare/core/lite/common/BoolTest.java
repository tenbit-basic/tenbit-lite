package cn.tenbit.hare.core.lite.common;

import cn.tenbit.hare.core.lite.util.HareBoolUtils;
import cn.tenbit.hare.core.lite.util.HarePrintUtils;
import org.junit.Test;

/**
 * @Author bangquan.qian
 * @Date 2019-07-17 16:51
 */
public class BoolTest {

    @Test
    public void test() {
        HarePrintUtils.console(HareBoolUtils.toBool(1));
        HarePrintUtils.console(HareBoolUtils.toInt(true));
        HarePrintUtils.console(HareBoolUtils.getBoolByChinese("真"));
        HarePrintUtils.console(HareBoolUtils.toBoolean(null));
        HarePrintUtils.console(HareBoolUtils.getBoolByEnglish("false"));
    }
}
