package cn.tenbit.hare.core.lite.common.bool;

/**
 * @Author bangquan.qian
 * @Date 2019-07-17 16:17
 */
public enum HareBoolEnums {

    TRUE(true, 1, "真", "true"),
    FALSE(false, 0, "假", "false"),
    ;

    HareBoolEnums(boolean boolVal, int intVal, String chineseVal, String englishVal) {
        this.boolVal = boolVal;
        this.intVal = intVal;
        this.chineseVal = chineseVal;
        this.englishVal = englishVal;
    }

    private boolean boolVal;

    private int intVal;

    private String chineseVal;

    private String englishVal;

    public boolean getBoolVal() {
        return boolVal;
    }

    public int getIntVal() {
        return intVal;
    }

    public String getChineseVal() {
        return chineseVal;
    }

    public String getEnglishVal() {
        return englishVal;
    }
}
