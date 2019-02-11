package com.chengshi.qixingshe.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2018-12-06
 */
@Repository
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据角色查找角色
     *
     * @param id
     * @return
     */
    Role findRoleById(int id);

    /**
     * @param query
     * @param condition
     * @return
     * @Description 查找角色列表
     */
    public List<Object> selectRoleList(Query<Object> query, Map<String, Object> condition);
}
