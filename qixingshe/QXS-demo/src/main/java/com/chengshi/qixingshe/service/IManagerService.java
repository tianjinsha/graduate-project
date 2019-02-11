package com.chengshi.qixingshe.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.Manager;
import com.baomidou.mybatisplus.service.IService;
import com.chengshi.qixingshe.model.User;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-01
 */
public interface IManagerService extends IService<Manager> {

    /**
     * @param id 单个管理员数据
     * @return
     */
    Manager findManagerById(Integer id);

    /**
     * 管理员数据集合
     *
     * @return
     */
    List<Manager> findManagerList();

    /**
     * 分页管理员数据
     *
     * @param page
     * @param wrapper
     * @return
     */
    Page findManagerPage(Query<Object> page, EntityWrapper<Manager> wrapper);

    /**
     * 添加管理员数据
     *
     * @param manager
     * @return
     */
    Boolean addManager(Manager manager);

    /**
     * 跟新管理员数据
     *
     * @param manager
     * @return
     */
    Boolean updateManager(Manager manager);

    /**
     * 删除管理员数据
     *
     * @param id
     * @return
     */
    Boolean deleteManager(Integer id);

    /**
     * 失效管理员
     *
     * @param id
     * @return
     */
    Boolean disableManager(Integer id);

    /**
     * 开启管理员
     *
     * @param id
     * @return
     */
    Boolean enableManager(Integer id);

    /**
     * 批量失效管理员
     *
     * @param ids
     * @return
     */
    Boolean batchDisableManager(List<Integer> ids);


}
