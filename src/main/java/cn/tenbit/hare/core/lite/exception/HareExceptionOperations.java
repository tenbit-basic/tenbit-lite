package cn.tenbit.hare.core.lite.exception;

public class HareExceptionOperations {

    private final HareException e;

    public HareExceptionOperations(HareException e) {
        this.e = e;
    }

    public void makeThrow() {
        throw newOne();
    }

    public HareException newOne() {
        return HareException.of(e.getCode(), e.getMessage(), e.getCause());
    }
}