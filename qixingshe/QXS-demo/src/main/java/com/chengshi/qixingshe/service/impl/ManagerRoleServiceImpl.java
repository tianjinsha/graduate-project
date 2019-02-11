package com.chengshi.qixingshe.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.dao.ManagerRoleMapper;
import com.chengshi.qixingshe.model.ManagerRole;
import com.chengshi.qixingshe.service.IManagerRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
@Service
public class ManagerRoleServiceImpl extends ServiceImpl<ManagerRoleMapper, ManagerRole> implements IManagerRoleService {
    @Autowired
    ManagerRoleMapper managerRoleMapper;

    @Override
    public ManagerRole findManagerRoleById(Integer id) {
        ManagerRole managerRole = new ManagerRole();
        managerRole.setId(id);
        return managerRoleMapper.selectOne(managerRole);
    }

    @Override
    public List<ManagerRole> findManagerRoleList() {
        return managerRoleMapper.selectList(new EntityWrapper<>());
    }

    @Override
    public Page findManagerRolePage(Query<Object> page, EntityWrapper<ManagerRole> wrapper) {
        page.setSize(10);
        page.setRecords(managerRoleMapper.findManagerRolePage(page, page.getCondition()));
        return page;
    }

    @Override
    public Boolean addManager(ManagerRole managerRole) {
        managerRole.setCreateTime(new Date());
        int count = managerRoleMapper.insert(managerRole);
        if (count == 1)
            return true;
        return false;
    }

    @Override
    public Boolean updateManagerRole(ManagerRole managerRole) {
        int count = managerRoleMapper.updateById(managerRole);
        if (count == 1)
            return true;
        return false;
    }

    @Override
    public Boolean deleteManagerRole(Integer id) {
        ManagerRole managerRole = new ManagerRole();
        managerRole.setId(id);
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.setEntity(managerRole);
        int count = managerRoleMapper.delete(wrapper);
        if (count == 1)
            return true;
        return false;
    }

    @Override
    public Boolean disableManagerRole(Integer id) {
        ManagerRole managerRole = new ManagerRole();
        managerRole.setId(id);
        managerRole.setStatus("0");
        int count = managerRoleMapper.updateById(managerRole);
        if (count == 1)
            return true;
        return false;
    }

    @Override
    public Boolean enableManagerRole(Integer id) {
        ManagerRole managerRole = new ManagerRole();
        managerRole.setId(id);
        managerRole.setStatus("1");
        int count = managerRoleMapper.updateById(managerRole);
        if (count == 1)
            return true;
        return false;
    }

    @Override
    public Boolean batchDisableManagerRole(List<Integer> ids) {
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.in("status", ids);
        int count = managerRoleMapper.updateForSet("status", wrapper);
        if (count == ids.size())
            return true;
        return false;
    }
}
