package com.djcps.validator.common.base;

import lombok.Data;

/**
 * @author yhc
 * @create 2020-05-07 20:29
 */
@Data
public class BaseModel {
    private String id;
    private String rowid;
    private String isdel;
    private String isdelPer;
    private String createTime;
    private String updateTime;
    private String skey;
}
