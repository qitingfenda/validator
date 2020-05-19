package com.djcps.validator.common.entity;

import com.djcps.validator.common.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 消息代办样式表
 *
 * @author yhc
 * @create 2020-04-21 18:08
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MsgStyle extends BaseModel {
    /**
     * 标题
     */
    private String title;
    /**
     * 值
     */
    private String value;
}
