package com.chengshi.qixingshe.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.Role;
import com.baomidou.mybatisplus.service.IService;
import com.chengshi.qixingshe.model.User;

import java.sql.Wrapper;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-06
 */
public interface IRoleService extends IService<Role> {

    /**
     * 角色列表
     * @return
     */
    public Page findRoleList(Query<Object> query, EntityWrapper<Role> wrapper);

    /**
     * 根据id查找角色
     * @param id
     * @return
     */
    public Role findRoleById(Integer id);

    /**
     * 根据名称查找角色
     * @param name
     * @return
     */
    public Role findRoleByName(String name);

    /**
     * 根据id删除角色
     * @param id
     * @return
     */
    public Boolean deleteRoleByid(Integer id);

    /**
     * 更新角色
     * @param role
     * @return
     */
    public Boolean updateRole(Role role);

    /**
     * 添加角色
     * @param role
     * @return
     */
    public Boolean addRole(Role role);

    /**
     * 启用角色
     * @param id
     * @return
     */
    public  Boolean disableRole(Integer id);

    /**
     * 禁用角色
     * @param id
     * @return
     */
    public Boolean enableRole(Integer id);
}
