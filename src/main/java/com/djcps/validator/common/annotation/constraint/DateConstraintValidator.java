package com.djcps.validator.common.annotation.constraint;

import com.djcps.validator.common.annotation.DateValid;
import com.djcps.validator.common.enums.FormatEnum;
import org.springframework.util.ObjectUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

/**
 * @author yhc
 * @date 2019-10-17 19:25
 */
public class DateConstraintValidator implements ConstraintValidator<DateValid, String> {

    /**
     * 格式
     */
    private FormatEnum format;

    @Override
    public void initialize(DateValid constraintAnnotation) {
        format = constraintAnnotation.format();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!ObjectUtils.isEmpty(value)) {
            return valid(format, value);
        }
        return true;
    }

    /**
     * 该方法对外提供
     * 校验value是否是format格式
     *
     * @param format 格式
     * @param value  值
     * @return true 格式正确、false格式错误
     */
    public static boolean valid(FormatEnum format, String value) {
        try {
            switch (format) {
                case DATE_TIME:
                    LocalDateTime.parse(value, DateTimeFormatter.ofPattern(format.getCode()));
                    break;
                case DATE:
                    LocalDate.parse(value, DateTimeFormatter.ofPattern(format.getCode()));
                    break;
                case TIME:
                    LocalTime.parse(value, DateTimeFormatter.ofPattern(format.getCode()));
                    break;
                case YEAR_MONTH:
                    YearMonth.parse(value, DateTimeFormatter.ofPattern(format.getCode()));
                    break;
                default:
                    return false;
            }
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}