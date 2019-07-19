package cn.tenbit.hare.core.lite.proxy.cglib;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author bangquan.qian
 * @Date 2019-07-19 14:04
 */
public class HareDefaultMethodInterceptor<T> implements HareMethodInterceptor<T> {

    private T target;

    public HareDefaultMethodInterceptor(T target) {
        this.target = target;
    }

    @Override
    public final Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        return doIntercept(proxy, method, args, methodProxy);
    }

    protected Object doIntercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        return method.invoke(target, args);
    }
}
