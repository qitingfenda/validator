package com.djcps.validator.common.enums;

/**
 * db枚举
 *
 * @author yhc
 * @date 2019-10-29 17:29
 */
public enum IsDelEnum {
    /**
     *msg
     */
    NO_DELETE("0"),
    DELETED("1"),
    REMOVE_CONDITIONS("-1"),
    ;

    private String code;

    IsDelEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
