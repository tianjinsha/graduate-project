package com.chengshi.qixingshe.dao;

import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.ManagerRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
public interface ManagerRoleMapper extends BaseMapper<ManagerRole> {
    List<Object> findManagerRolePage(Query<Object> query, Map<String, Object> condition);
}
