package cn.tenbit.hare.core.lite.util;

import cn.tenbit.hare.core.lite.constant.HareConsts;
import cn.tenbit.hare.core.lite.proxy.cglib.HareDefaultMethodInterceptor;
import cn.tenbit.hare.core.lite.proxy.cglib.HareMethodInterceptor;
import cn.tenbit.hare.core.lite.proxy.cglib.HareSimpleMethodInterceptor;
import cn.tenbit.hare.core.lite.proxy.jdk.HareDefaultInvocationHandler;
import cn.tenbit.hare.core.lite.proxy.jdk.HareInvocationHandler;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * @Author bangquan.qian
 * @Date 2019-07-19 13:52
 */
@SuppressWarnings(HareConsts.SUPPRESS_WARNING_UNCHECKED)
public class HareProxyUtils {

    public static <T> T jdk(ClassLoader cl, Class<?>[] ifs, HareInvocationHandler<T> ih) {
        return (T) Proxy.newProxyInstance(cl, ifs, ih);
    }

    public static <T> T jdk(Class<?>[] ifs, HareInvocationHandler<T> ih) {
        return jdk(ClassLoader.getSystemClassLoader(), ifs, ih);
    }

    public static <T> T jdk(Class<?> inf, HareInvocationHandler<T> ih) {
        return jdk(new Class[]{inf}, ih);
    }

    public static <T> T jdk(Class<?> inf, T target) {
        return jdk(inf, new HareDefaultInvocationHandler<>(target));
    }

    public static <T> T jdk(T target) {
        return jdk(target.getClass().getInterfaces(), new HareDefaultInvocationHandler<>(target));
    }

    public static <T> T cglib(T target, HareMethodInterceptor<T> mi) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(mi);
        return (T) enhancer.create();
    }

    public static <T> T cglib(T target) {
        return cglib(target, new HareDefaultMethodInterceptor<>(target));
    }

    public static <T> T simpleCglib(T target) {
        return cglib(target, new HareSimpleMethodInterceptor<>());
    }
}
