package com.djcps.validator.common.dao;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

/**
 * @author yhc
 * @create 2020-05-07 20:23
 */
public interface CommonDao {

    /**
     * 根据实体类id查找实体类信息
     *
     * @param tableName 类名
     * @param id        id
     * @param isDel     是否删除
     * @return 实体类信息
     * @author yhc
     * @date 2019/12/12 20:35
     */
    HashMap<String, Object> getBaseModelById(@Param("tableName") String tableName,
                                             @Param("id") String id,
                                             @Param("isDel") String isDel);

}
