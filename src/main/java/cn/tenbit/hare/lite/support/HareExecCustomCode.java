package cn.tenbit.hare.lite.support;

import cn.tenbit.hare.lite.exception.HareExecCode;

/**
 * @Author bangquan.qian
 * @Date 2019-06-13 18:38
 */
public interface HareExecCustomCode {

    HareExecCode UNSUPPORTED = HareExecCode.newFailure("unsupported");
}
