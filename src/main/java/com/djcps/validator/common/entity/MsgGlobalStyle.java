package com.djcps.validator.common.entity;

import com.djcps.validator.common.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 全局样式表
 *
 * @author yhc
 * @date 2020/4/27 10:30
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MsgGlobalStyle extends BaseModel {
    /**
     * 业务id
     */
    private String businessId;
    /**
     * 标签
     */
    private String label;
    /**
     * 值
     */
    private String value;
    /**
     * 样式类型
     */
    private String type;
    /**
     * 多选框的选项内容(JSONArray)
     */
    private String options;
    /**
     * 控件分类(0-基础组件，1-套件)
     */
    private String controlClass;
    /**
     * 置灰底字
     */
    private String placeholder;
    /**
     * 最小长度
     */
    private String min;
    /**
     * 最大长度
     */
    private String max;
    /**
     * 检查类型(0-不检查，1-整型，2-浮点型，3-手机号，4-邮箱，5-身份证，6-座机)
     */
    private String checkType;
    /**
     * 是否回传(0-不传递，1-传递)
     */
    private String isTransmit;
    /**
     * 参数名
     */
    private String key;
    /**
     * 路由地址
     */
    private String route;
}
