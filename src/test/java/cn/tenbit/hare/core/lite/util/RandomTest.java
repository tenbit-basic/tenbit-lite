package cn.tenbit.hare.core.lite.util;

import org.junit.Test;

/**
 * @Author bangquan.qian
 * @Date 2019-06-25 10:39
 */
public class RandomTest {

    @Test
    public void test() {
        int[] array = HareRandomUtils.randomIntArray(5, 0, 9);
        HarePrintUtils.jsonConsole(array);
    }
}
