package com.djcps.validator.common.annotation.constraint;

import com.djcps.validator.common.annotation.EnumValid;
import org.springframework.util.ObjectUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;

/**
 * @author yhc
 */
public class EnumConstraintValidator implements ConstraintValidator<EnumValid, String> {
    /**
     * 枚举类
     */
    private Class<?> cls;

    private boolean isMultiple;

    @Override
    public void initialize(EnumValid constraintAnnotation) {
        cls = constraintAnnotation.target();
        isMultiple = constraintAnnotation.isMultiple();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 为空返回true
        if (ObjectUtils.isEmpty(value)) {
            return true;
        }
        // 不是枚举返回false
        if (!cls.isEnum()) {
            return false;
        }
        try {
            if (isMultiple) {
                String[] enums = value.split(",");
                for (String e : enums) {
                    boolean flag = isEnum(cls, e);
                    if (!flag) {
                        return false;
                    }
                }
                return true;
            }
            return isEnum(cls, value);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private boolean isEnum(Class<?> cl, String value) throws Exception {
        //枚举类验证
        Object[] enums = cl.getEnumConstants();
        Method method = cl.getMethod("getCode");
        for (Object obj : enums) {
            Object code = method.invoke(obj);
            if (value.equals(code.toString())) {
                return true;
            }
        }
        return false;
    }

}