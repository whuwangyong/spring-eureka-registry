package cn.whu.rest;

/**
 * @Author WangYong
 * @Date 2019/12/03
 * @Time 11:22
 */
public enum BizType {
    BANK_OPEN("YHKS"),
    BANK_CLOSE("YHBS"),
    ;

    private String type;

    private BizType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
