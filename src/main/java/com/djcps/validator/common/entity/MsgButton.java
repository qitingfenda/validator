package com.djcps.validator.common.entity;

import com.djcps.validator.common.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 按钮表
 *
 * @author yhc
 * @date 2020/4/27 10:32
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MsgButton extends BaseModel {
    /**
     * 发文表id
     */
    private String publishId;
    /**
     * 按钮名称
     */
    private String name;
    /**
     * 提交url
     */
    private String submitUrl;
    /**
     * 提交类型(0-接口url，1-MQ)
     */
    private String submitType;
}
