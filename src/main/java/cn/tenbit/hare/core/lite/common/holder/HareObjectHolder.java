package cn.tenbit.hare.core.lite.common.holder;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author bangquan.qian
 * @Date 2019-06-24 13:43
 */
@Getter
@AllArgsConstructor(staticName = "of")
public class HareObjectHolder<T> {

    private T target;
}
