package com.chengshi.qixingshe.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.Manager;
import com.chengshi.qixingshe.model.ManagerRole;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-10
 */
public interface IManagerRoleService extends IService<ManagerRole> {
    /**
     * @param id
     * 单个管理员角色数据
     * @return
     */
    ManagerRole findManagerRoleById(Integer id);

    /**
     * 管理员角色数据集合
     * @return
     */
    List<ManagerRole> findManagerRoleList();

    /**
     * 分页管理员角色数据
     * @param page
     * @param wrapper
     * @return
     */
    Page findManagerRolePage(Query<Object> page, EntityWrapper<ManagerRole> wrapper);

    /**
     * 添加管理员数据
     * @param managerRole
     * @return
     */
    Boolean addManager(ManagerRole managerRole);

    /**
     * 跟新管理员数据
     * @param managerRole
     * @return
     */
    Boolean updateManagerRole(ManagerRole managerRole);

    /**
     * 删除管理员数据
     * @param id
     * @return
     */
    Boolean deleteManagerRole(Integer id);

    /**
     * 失效管理员角色
     * @param id
     * @return
     */
    Boolean disableManagerRole(Integer id);

    /**
     * 开启管理员
     * @param id
     * @return
     */
    Boolean enableManagerRole(Integer id);

    /**
     * 批量失效管理员角色
     * @param ids
     * @return
     */
    Boolean batchDisableManagerRole(List<Integer> ids);


}
