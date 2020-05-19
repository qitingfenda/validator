package com.djcps.validator.common.enums;

/**
 * 婚姻状态枚举
 *
 * @author yhc
 * @date 2019-10-08 17:13
 */
public enum UserMaritalStatus implements EnumInterface {
    /**
     * enum
     */
    CONFIDENTIALITY("保密"),
    UNMARRIED("未婚"),
    MARRIED("已婚"),
    ;

    private String code;

    UserMaritalStatus(String code){
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}
