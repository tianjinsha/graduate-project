package com.chengshi.fitness.service.impl;

import com.chengshi.fitness.model.Manager;
import com.chengshi.fitness.dao.ManagerMapper;
import com.chengshi.fitness.service.IManagerService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements IManagerService {
    @Autowired
    ManagerMapper managerMapper;

    @Override
    public Manager findManagerByName(String username) {
        Manager manager=new Manager();
        manager.setUsername(username);
        return managerMapper.selectOne(manager);
    }
}
