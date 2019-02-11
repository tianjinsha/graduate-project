package com.chengshi.qixingshe.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.dao.ManagerMapper;
import com.chengshi.qixingshe.model.Manager;
import com.chengshi.qixingshe.service.IManagerService;
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
 * @since 2018-12-01
 */
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements IManagerService {

    @Autowired
    ManagerMapper managerMapper;

    @Override
    public Manager findManagerById(Integer id) {
        Manager manager = new Manager();
        manager.setId(id);
        return managerMapper.selectOne(manager);
    }

    @Override
    public List<Manager> findManagerList() {
        return managerMapper.selectList(new EntityWrapper<>());
    }

    @Override
    public Page findManagerPage(Query<Object> page, EntityWrapper<Manager> wrapper) {
        page.setSize(10);
        page.setRecords(managerMapper.findManagerPage(page, page.getCondition()));
        return page;
    }

    @Override
    public Boolean addManager(Manager manager) {
        manager.setCreateTime(new Date());
        int count = managerMapper.insert(manager);
        if (count == 1)
            return true;
        return false;
    }

    @Override
    public Boolean updateManager(Manager manager) {
        int count = managerMapper.updateById(manager);
        if (count == 1)
            return true;
        return false;
    }

    @Override
    public Boolean deleteManager(Integer id) {
        Manager manager = new Manager();
        manager.setId(id);
        EntityWrapper<Manager> wrapper = new EntityWrapper<>();
        wrapper.setEntity(manager);
        int count = managerMapper.delete(wrapper);
        if (count == 1)
            return true;
        return false;
    }

    @Override
    public Boolean disableManager(Integer id) {
        Manager manager = new Manager();
        manager.setId(id);
        manager.setStatus("0");
        EntityWrapper<Manager> wrapper = new EntityWrapper<>();
        wrapper.setEntity(manager);
        int count = managerMapper.updateById(manager);
        if (count == 1)
            return true;
        return false;
    }

    @Override
    public Boolean enableManager(Integer id) {
        Manager manager = new Manager();
        manager.setId(id);
        manager.setStatus("1");
        EntityWrapper<Manager> wrapper = new EntityWrapper<>();
        wrapper.setEntity(manager);
        int count = managerMapper.updateById(manager);
        if (count == 1)
            return true;
        return false;
    }

    @Override
    public Boolean batchDisableManager(List<Integer> ids) {
        EntityWrapper<Manager> wrapper = new EntityWrapper<>();
        wrapper.in("status", ids);
        int count = managerMapper.updateForSet("status", wrapper);
        if (count == ids.size())
            return true;
        return false;
    }
}
