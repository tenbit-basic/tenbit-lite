package cn.tenbit.hare.core.lite.util;

import org.junit.Test;

/**
 * @Author bangquan.qian
 * @Date 2019-07-23 15:51
 */
public class Inet4AddressTest {

    @Test
    public void test() {
        
        String rawIp = HareInet4AddressUtils.number2Text(
                HareInet4AddressUtils.bytes2Number(
                        HareInet4AddressUtils.text2Bytes(
                                HareInet4AddressUtils.bytes2Text(
                                        HareInet4AddressUtils.number2Bytes(
                                                HareInet4AddressUtils.text2Number("117.43.54.22")
                                        )
                                )
                        )
                )
        );

        HarePrintUtils.console(rawIp);
    }
}
