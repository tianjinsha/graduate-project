package com.chengshi.qixingshe.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.Role;
import com.chengshi.qixingshe.dao.RoleMapper;
import com.chengshi.qixingshe.model.User;
import com.chengshi.qixingshe.service.IRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.sql.Wrapper;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-06
 */
@Service
@Slf4j
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public Page findRoleList(Query<Object> query, EntityWrapper<Role> wrapper) {
        query.setSize(10);
        query.setRecords(roleMapper.selectRoleList(query, query.getCondition()));
        return query;
    }

    @Override
    public Role findRoleById(Integer id) {
        log.info("id:"+id);
        Role role=new Role();
        role.setId(id);
        return roleMapper.selectOne(role);
    }

    @Override
    public Role findRoleByName(String name) {
        Role role=new Role();
        role.setName(name);
        return roleMapper.selectOne(role);
    }

    @Override
    public Boolean deleteRoleByid(Integer id) {
        Role role=new Role();
        role.setId(id);
        EntityWrapper<Role> roleEntityWrapper=new EntityWrapper<>();
        roleEntityWrapper.setEntity(role);
        int count =roleMapper.delete(roleEntityWrapper);
        if (count==1)
            return true;
        return false;
    }

    @Override
    public Boolean updateRole(Role role) {
        int count =roleMapper.updateById(role);
        if (count==1)
            return true;
        return false;
    }

    @Override
    public Boolean addRole(Role role) {
        role.setCreateTime(new Date());
        int count=roleMapper.insert(role);
        if (count==1)
            return true;
        return false;
    }

    @Override
    public Boolean disableRole(Integer id) {
        Role role=new Role();
        role.setId(id);
        role.setStatus("0");
        int count =roleMapper.updateById(role);
        if (count==1)
            return true;
        return false;
    }

    @Override
    public Boolean enableRole(Integer id) {
        Role role=new Role();
        role.setId(id);
        role.setStatus("1");
        int count =roleMapper.updateById(role);
        if (count==1)
            return true;
        return false;
    }
}
