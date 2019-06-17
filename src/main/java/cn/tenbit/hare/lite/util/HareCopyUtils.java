package cn.tenbit.hare.lite.util;

import cn.tenbit.hare.lite.constant.HareConsts;
import cn.tenbit.hare.lite.exception.HareException;
import net.sf.cglib.beans.BeanCopier;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author bangquan.qian
 * @Date 2019-06-14 16:09
 */
public class HareCopyUtils {

    /**
     * 对象浅拷贝
     */
    public static <S, T> T copyObject(S s, Class<T> clz, String... ignoreProperties) {
        if (s == null) {
            return null;
        }

        try {
            T t = clz.newInstance();
            copyProperties(s, t, ignoreProperties);
            return t;
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

    private static <S, T> void copyProperties(S s, T t, String... ignoreProperties) {
        BeanCopier beanCopier = findBeanCopier(s.getClass(), t.getClass());
        beanCopier.copy(s, t, null);
    }

    private static final Map<String, BeanCopier> CACHE = new ConcurrentHashMap<>();

    private static BeanCopier findBeanCopier(Class<?> s, Class<?> t) {
        String cacheKey = getCacheKey(s, t);
        BeanCopier beanCopier = CACHE.get(cacheKey);
        if (beanCopier == null) {
            CACHE.put(cacheKey, beanCopier = BeanCopier.create(s, t, false));
        }
        return beanCopier;
    }

    private static String getCacheKey(Class<?> s, Class<?> t) {
        return StringUtils.joinWith(HareConsts.UL, s.getCanonicalName(), t.getCanonicalName());
    }
}
