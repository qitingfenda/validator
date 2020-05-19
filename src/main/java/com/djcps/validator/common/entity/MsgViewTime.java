package com.djcps.validator.common.entity;

import com.djcps.validator.common.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 通知消息查看时间
 *
 * @author yhc
 * @create 2020-05-06 10:27
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MsgViewTime extends BaseModel {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 上一次查看时间
     */
    private String viewTime;

}
