package cn.tenbit.hare.core.lite.bean.copy;

public interface HareBeanCopy<S, R> {

    R copy(S src, Class<R> retCLz, String... ignoreProperties);
}