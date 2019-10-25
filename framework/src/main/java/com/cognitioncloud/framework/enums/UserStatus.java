package com.cognitioncloud.framework.enums;

/**
 * 用户状态
 *
 * @author 1122
 */
public enum UserStatus {

    /**
     * OK，0,正常
     */
    OK("0", "正常"),
    /**
     * DISABLE，1,停用
     */
    DISABLE("1", "停用"),
    /**
     * DELETED,2,删除
     */
    DELETED("2", "删除");

    /**
     * 编号
     */
    private final String code;
    /**
     * 信息
     */
    private final String info;

    UserStatus(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
