package com.djcps.validator.user.model;

import com.djcps.validator.common.annotation.DateValid;
import com.djcps.validator.common.annotation.EnumValid;
import com.djcps.validator.common.annotation.IdValid;
import com.djcps.validator.common.entity.MsgStyle;
import com.djcps.validator.common.enums.FormatEnum;
import com.djcps.validator.common.enums.UserMaritalStatus;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author yhc
 * @create 2020-05-06 20:49
 */
@Data
public class AddUserModel {
    /**
     * 名字
     */
    @NotBlank
    private String name;
    /**
     * 角色列表
     */
    @Size(min = 1)
    private List<String> roleList;
    /**
     * 入职时间
     * 时间格式校验
     */
    @DateValid(format = FormatEnum.DATE_TIME)
    private String time;
    /**
     * 婚姻状态
     * 枚举校验
     */
    @EnumValid(target = UserMaritalStatus.class)
    private String maritalStatus;

    @IdValid(target = MsgStyle.class)
    private String msgStyleId;
}
