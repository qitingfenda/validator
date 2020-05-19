package com.djcps.validator.common.annotation;

import com.djcps.validator.common.annotation.constraint.DateConstraintValidator;
import com.djcps.validator.common.enums.FormatEnum;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 日期校验
 *
 * @author yhc
 * @date 2019-10-17 19:25
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.FIELD)
@Constraint(validatedBy = DateConstraintValidator.class)
public @interface DateValid {

    String message() default "时间格式错误";

    /**
     * 自定义时间格式-默认为yyyy-MM-dd HH:mm:ss
     */
    FormatEnum format() default FormatEnum.DATE_TIME;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
