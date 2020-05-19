package com.djcps.validator.common.base;

import com.djcps.validator.common.dao.CommonDao;
import com.djcps.validator.common.enums.IsDelEnum;
import com.djcps.validator.common.utils.StringUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author yhc
 * @create 2020-05-07 20:27
 */
@Service
public class BaseService {

    @Autowired
    private CommonDao commonDao;

    /**
     * 根据实体类id查找实体类信息
     *
     * @param id     id
     * @param clazz  实体类
     * @return 实体类信息
     * @author yhc
     * @date 2019/12/30 12:09
     */
    protected <T extends BaseModel> T getBaseModelById(String id, Class<T> clazz) {
        try {
            // 获取类名
            String className = clazz.getSimpleName();
            // 驼峰转换表名
            String tableName = StringUtil.humpToUnderline(className);
            String isDel = IsDelEnum.NO_DELETE.getCode();
            // 根据不同数据源调用不同dao
            HashMap<String, Object> resultMap = commonDao.getBaseModelById(tableName, id, isDel);
            if (ObjectUtils.isEmpty(resultMap)) {
                return null;
            }
            // 转驼峰
            Set<Map.Entry<String, Object>> entrySet = resultMap.entrySet();
            Map<String, Object> newResultMap = entrySet.stream()
                    .collect(Collectors.toMap(o -> StringUtil.underlineToHump(o.getKey()), Map.Entry::getValue));
            T t = clazz.newInstance();
            // 复制属性
            BeanUtils.populate(t, newResultMap);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
