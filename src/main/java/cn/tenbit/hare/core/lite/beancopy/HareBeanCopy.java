package cn.tenbit.hare.core.lite.beancopy;

public interface HareBeanCopy<S, R> {

    R copy(S src, Class<R> retCLz, String... ignoreProperties);
}