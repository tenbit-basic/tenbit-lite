package cn.tenbit.hare.core.lite.execute.intercept;

import cn.tenbit.hare.core.lite.util.HareAssertUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author bangquan.qian
 * @Date 2019-06-20 10:20
 */
public class HareInterceptChain<T> {

    private List<HareInterceptable<T>> interceptables = new ArrayList<>();

    private HareInterceptChain() {
    }

    public static <T> HareInterceptChainBuilder<T> newBuilder() {
        return new HareInterceptChainBuilder<>();
    }

    public static class HareInterceptChainBuilder<T> {

        private HareInterceptChain<T> chain = new HareInterceptChain<>();

        public HareInterceptChainBuilder<T> then(HareInterceptable<T> interceptable) {
            HareAssertUtils.notNull(interceptable);
            chain.interceptables.add(interceptable);
            return this;
        }

        public HareInterceptChain<T> build() {
            return chain;
        }
    }

    public T execute(T target) throws Exception {
        for (HareInterceptable<T> interceptable : interceptables) {
            HareAssertUtils.notNull(target);
            target = interceptable.intercept(target);
        }
        return target;
    }
}
