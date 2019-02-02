package com.chengshi.qixingshe.dao;

import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.Role;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2018-12-06
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据角色查找角色
     * @param id
     * @return
     */
    Role findRoleById(int id);

    /**
     * @Description 查找角色列表
     * @param query
     * @param condition
     * @return
     */
    public List<Object> selectRoleList(Query<Object> query, Map<String, Object> condition);
}
