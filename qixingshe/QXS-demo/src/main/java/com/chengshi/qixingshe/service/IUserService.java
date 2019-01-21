package com.chengshi.qixingshe.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.User;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-01
 */
public interface IUserService extends IService<User> {

    /**
     * @param id
     * @return
     * @Description 根据Id查找用户
     */
    User findUserById(Integer id);

    /**
     * @return
     * @Description 用户列表
     */
    List<User> findUserList();

    /**
     * @Description 分页查询
     * @param page 查询条件
     * @param wrapper
     * @return
     */
    Page findUserPage(Query<Object> page, EntityWrapper<User> wrapper);

    /**
     * 删除的用户
     * @param page
     * @param wrapper
     * @return
     */
    Page findUserPageDelete(Query<Object> page, EntityWrapper<User> wrapper);

    /**
     * @param user
     * @return
     * @Description 添加用户
     */
    Boolean addUser(User user);

    /**
     *
     * @return
     * @param id
     * @Description 删除用户
     */
    Boolean deleteUser(Integer id);

    /**
     * 恢复用户 1
     * @param id
     * @return
     */
    Boolean recoverUser(Integer id);

    /**
     * @Description 停用用户 2
     * @param id
     * @return
     */
    Boolean stopUser(Integer id);

    /**
     * 临时删除用户，使其失效 0
     * @param id
     * @return
     */
    Boolean disableUser(Integer id);

    /**
     * @param user
     * @return
     * @Description 修改用户
     */
    Boolean modifyUser(User user);

    /**
     * 批量失效用户
     * @param ids
     * @return
     */
    Boolean batchDisableUser(List<Integer> ids);

    /**
     * 批量恢复用户
     * @param ids
     * @return
     */
    Boolean batchRecoverUser(List<Integer> ids);
}
