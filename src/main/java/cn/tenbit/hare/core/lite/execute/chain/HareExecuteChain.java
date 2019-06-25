package cn.tenbit.hare.core.lite.execute.chain;

import cn.tenbit.hare.core.lite.exception.HareException;
import cn.tenbit.hare.core.lite.util.HareAssertUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author bangquan.qian
 * @Date 2019-04-15 23:43
 */

public class HareExecuteChain<T> {

    private List<HareExecutable<T>> executables = new ArrayList<>();

    private HareOnCatchExecutable<T> onCatchExecutable;

    private HareExecutable<T> onFinallyExecutable;

    private HareExecuteChain() {
    }

    public static <T> JxExecuteChainBuilder<T> newBuilder() {
        return new JxExecuteChainBuilder<T>();
    }

    public static class JxExecuteChainBuilder<E> {

        private HareExecuteChain<E> chain = new HareExecuteChain<>();

        public JxExecuteChainBuilder<E> then(HareExecutable<E> executable) {
            HareAssertUtils.notNull(executable, "executable is null");
            chain.executables.add(executable);
            return this;
        }

        public JxExecuteChainBuilder<E> onCatch(HareOnCatchExecutable<E> executable) {
            HareAssertUtils.notNull(executable, "executable is null");
            if (chain.onCatchExecutable != null) {
                throw HareException.of("onCatch already set");
            }
            chain.onCatchExecutable = executable;
            return this;
        }

        public JxExecuteChainBuilder<E> onFinally(HareExecutable<E> executable) {
            HareAssertUtils.notNull(executable, "executable is null");
            if (chain.onFinallyExecutable != null) {
                throw HareException.of("onFinally already set");
            }
            chain.onFinallyExecutable = executable;
            return this;
        }

        public HareExecuteChain<E> build() {
            return chain;
        }

    }

    public T execute(T target) throws Exception {
        HareAssertUtils.notNull(target, "target is null");
        try {
            for (HareExecutable<T> executable : executables) {
                executable.execute(target);
            }
        } catch (Throwable e) {
            if (onCatchExecutable != null) {
                onCatchExecutable.execute(target, e);
            } else {
                throw e;
            }
        } finally {
            if (onFinallyExecutable != null) {
                onFinallyExecutable.execute(target);
            }
        }
        return target;
    }

}
