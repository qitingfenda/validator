package com.djcps.validator.common.annotation;


import com.djcps.validator.common.annotation.constraint.EnumConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author yhc
 */
@Constraint(validatedBy = {EnumConstraintValidator.class})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.FIELD)
public @interface EnumValid {

    /**
     * 是否是多个，默认未false。为true时，传递的枚举通过逗号分隔
     */
    boolean isMultiple() default false;

    String message() default "非法请求";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<?> target();

}
