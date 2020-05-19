package com.djcps.validator.common.annotation;


import com.djcps.validator.common.annotation.constraint.IdConstraintValidator;
import com.djcps.validator.common.base.BaseModel;
import com.djcps.validator.common.enums.IsDelEnum;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * id自定义校验,多个id用逗号分隔
 *
 * @author yhc
 * @date 2019-10-17 8:38
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.FIELD)
@Constraint(validatedBy = IdConstraintValidator.class)
public @interface IdValid {

    String message() default "非法请求";

    /**
     * 是否不能为空
     * 默认为true-该id不能为空
     */
    boolean isNotNull() default true;

    /**
     * 是否删除的数据也查询出来，默认查询未删除的数据
     */
    IsDelEnum isDel() default IsDelEnum.NO_DELETE;

    Class<? extends BaseModel> target();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
