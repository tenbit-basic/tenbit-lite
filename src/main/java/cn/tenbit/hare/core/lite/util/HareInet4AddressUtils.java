package cn.tenbit.hare.core.lite.util;

import java.net.Inet4Address;
import java.net.InetAddress;

/**
 * @Author bangquan.qian
 * @Date 2019-07-23 15:31
 */
public class HareInet4AddressUtils {

    public static int text2Number(String rawIp) {
        return HareInvokeUtils.invokeWithSwallow(() -> {
            InetAddress address = Inet4Address.getByName(rawIp);
            HareAssertUtils.notNull(address);
            return bytes2Number(address.getAddress());
        });
    }

    public static byte[] text2Bytes(String rawIp) {
        return number2Bytes(text2Number(rawIp));
    }

    public static String number2Text(int address) {
        return bytes2Text(number2Bytes(address));
    }

    public static byte[] number2Bytes(int address) {
        byte[] addr = new byte[4];
        addr[0] = (byte) ((address >>> 24) & 0xFF);
        addr[1] = (byte) ((address >>> 16) & 0xFF);
        addr[2] = (byte) ((address >>> 8) & 0xFF);
        addr[3] = (byte) (address & 0xFF);
        return addr;
    }

    public static String bytes2Text(byte[] bytes) {
        return (bytes[0] & 0xff) + "."
                + (bytes[1] & 0xff) + "."
                + (bytes[2] & 0xff) + "."
                + (bytes[3] & 0xff);
    }

    public static int bytes2Number(byte[] bytes) {
        HareAssertUtils.isTrue(bytes != null && bytes.length == 4);

        return ((bytes[0] << 24) & 0xff_00_00_00)
                + ((bytes[1] << 16) & 0x00_ff_00_00)
                + ((bytes[2] << 8) & 0x00_00_ff_00)
                + (bytes[3] & 0x00_00_00_ff);
    }

}
