package com.chengshi.fitness.service;

import com.chengshi.fitness.model.Manager;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 管理员 服务类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-16
 */
public interface IManagerService extends IService<Manager> {

    Manager findManagerByName(String username);

}
