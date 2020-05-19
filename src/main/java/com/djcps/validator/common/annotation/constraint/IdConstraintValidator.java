package com.djcps.validator.common.annotation.constraint;

import com.djcps.validator.common.annotation.IdValid;
import com.djcps.validator.common.base.BaseModel;
import com.djcps.validator.common.dao.CommonDao;
import com.djcps.validator.common.enums.IsDelEnum;
import com.djcps.validator.common.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashMap;

/**
 * @author yhc
 * @date 2019-10-17 8:44
 */
public class IdConstraintValidator implements ConstraintValidator<IdValid, String> {

    @Autowired
    private CommonDao commonDao;

    /**
     * 类
     */
    private Class<? extends BaseModel> target;

    /**
     * 是否为空-默认不能为空
     */
    private boolean isNotNull;

    /**
     * 是否删除
     */
    private IsDelEnum isDel;

    @Override
    public void initialize(IdValid constraintAnnotation) {
        target = constraintAnnotation.target();
        isNotNull = constraintAnnotation.isNotNull();
        isDel = constraintAnnotation.isDel();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            if (ObjectUtils.isEmpty(value)) {
                return !isNotNull;
            }
            // 获取类名
            String className = target.getSimpleName();
            // 驼峰转换表名
            String tableName = StringUtil.humpToUnderline(className);
            String[] ids = value.split(",");
            for (String id : ids) {
                HashMap<String, Object> model = commonDao.getBaseModelById(tableName, id, isDel.getCode());
                if (ObjectUtils.isEmpty(model)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
