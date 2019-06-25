package cn.tenbit.hare.core.lite.bean.copy;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 15:55
 */
public class HareBeanCopyFactory {

    public static HareBeanCopy getBeanCopy() {
        return new HareCglibBeanCopy();
    }
}
