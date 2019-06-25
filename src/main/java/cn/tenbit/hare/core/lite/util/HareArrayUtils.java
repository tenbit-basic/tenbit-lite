package cn.tenbit.hare.core.lite.util;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author bangquan.qian
 * @Date 2019-06-25 10:50
 */
public class HareArrayUtils {

    public static List<Integer> intArr2IntegerList(int[] arr) {
        if (ArrayUtils.isEmpty(arr)) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>(arr.length);
        for (int num : arr) {
            list.add(num);
        }
        return list;
    }
}
