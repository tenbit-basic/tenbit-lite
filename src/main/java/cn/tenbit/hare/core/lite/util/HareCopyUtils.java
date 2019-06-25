package cn.tenbit.hare.core.lite.util;

import cn.tenbit.hare.core.lite.bean.copy.HareBeanCopy;
import cn.tenbit.hare.core.lite.bean.copy.HareBeanCopyFactory;
import cn.tenbit.hare.core.lite.constant.HareConsts;
import cn.tenbit.hare.core.lite.exception.HareException;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author bangquan.qian
 * @Date 2019-06-14 16:09
 */
public class HareCopyUtils {

    private static final HareBeanCopy HARE_BEAN_COPY = HareBeanCopyFactory.getBeanCopy();

    /**
     * 对象浅拷贝
     */
    public static <S, T> T copyObject(S s, Class<T> clz, String... ignoreProperties) {
        if (s == null) {
            return null;
        }

        try {
            return copyProperties(s, clz, ignoreProperties);
        } catch (Exception e) {
            throw HareException.of("copyObject", e);
        }
    }

    /**
     * list浅拷贝
     */
    public static <S, T> List<T> copyList(Collection<S> srcs, Class<T> clz, String... ignoreProperties) {
        if (srcs == null) {
            return null;
        }
        if (CollectionUtils.isEmpty(srcs)) {
            return new ArrayList<>();
        }

        try {
            List<T> dsts = new ArrayList<>(srcs.size());
            for (S s : srcs) {
                dsts.add(copyObject(s, clz, ignoreProperties));
            }
            return dsts;
        } catch (Exception e) {
            throw HareException.of("copyList", e);
        }
    }

    @SuppressWarnings(HareConsts.SUPPRESS_WARNING_UNCHECKED)
    private static <S, T> T copyProperties(S s, Class<T> clz, String... ignoreProperties) {
        return (T) HARE_BEAN_COPY.copy(s, clz, ignoreProperties);
    }
}
