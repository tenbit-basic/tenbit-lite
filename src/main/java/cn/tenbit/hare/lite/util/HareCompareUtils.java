package cn.tenbit.hare.lite.util;

import cn.tenbit.hare.lite.constant.HareConsts;
import cn.tenbit.hare.lite.support.HareExecCustomCode;

/**
 * @Author bangquan.qian
 * @Date 2019-04-08 17:30
 */

public class HareCompareUtils {

    public enum CompareOperation {
        /* compare operation */
        EQ, NE, GT, LT, GE, LE
    }

    private static boolean boolify(int compare, CompareOperation operation) {
        boolean result = false;
        switch (operation) {
            default:
                break;
            case EQ:
                result = compare == 0;
                break;
            case NE:
                result = compare != 0;
                break;
            case GT:
                result = compare > 0;
                break;
            case LT:
                result = compare < 0;
                break;
            case GE:
                result = compare >= 0;
                break;
            case LE:
                result = compare <= 0;
                break;
        }
        return result;
    }

    @SuppressWarnings(HareConsts.SUPPRESS_WARNING_UNCHECKED)
    private static <T> boolean compare(T src, T dst, CompareOperation operation) {
        boolean result = false;
        if (src == dst) {
            switch (operation) {
                default:
                    break;
                case GE:
                case LE:
                case EQ:
                    result = true;
                    break;
                case NE:
                case GT:
                case LT:
                    result = false;
                    break;
            }
            return result;
        }
        if (src == null || dst == null) {
            switch (operation) {
                default:
                    break;
                case NE:
                    result = true;
                    break;
                case EQ:
                case GT:
                case LT:
                case GE:
                case LE:
                    result = false;
                    break;
            }
            return result;
        }
        if (src instanceof Comparable && dst instanceof Comparable) {
            return boolify(((Comparable) src).compareTo((Comparable) dst), operation);
        }
        throw HareExecCustomCode.UNSUPPORTED.newException();
    }

    // EQUAL
    public static <T> boolean eq(T src, T dst) {
        return compare(src, dst, CompareOperation.EQ);
    }

    // NOT EQUAL
    public static <T> boolean ne(T src, T dst) {
        return compare(src, dst, CompareOperation.NE);
    }

    // GREATER THAN
    public static <T> boolean gt(T src, T dst) {
        return compare(src, dst, CompareOperation.GT);
    }

    // LESS THAN
    public static <T> boolean lt(T src, T dst) {
        return compare(src, dst, CompareOperation.LT);
    }

    // GREATER THAN OR EQUAL
    public static <T> boolean ge(T src, T dst) {
        return compare(src, dst, CompareOperation.GE);
    }

    // LESS THAN OR EQUAL
    public static <T> boolean le(T src, T dst) {
        return compare(src, dst, CompareOperation.LE);
    }
}
