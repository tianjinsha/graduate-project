package com.chengshi.qixingshe.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.Manager;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2018-12-01
 */
@Repository
public interface ManagerMapper extends BaseMapper<Manager> {


    /**
     * 更具用户id查找用户
     *
     * @param id
     * @return
     */
    Manager findManagerById(int id);

    /**
     * 根据账号查找管理员
     * @param account
     * @return
     */
    Manager findManagerByAccount(String account);

    /**
     * 根据电话号码查找管理员
     * @param Phone
     * @return
     */
    Manager findManagerByPhone(String Phone);

    /**
     * 根据电子邮箱查找管理员
     * @param Email
     * @return
     */
    Manager findManagerByEmail(String Email);

    Manager findManagerByKey(Manager manager);

    /**
     * 分页查找所有管理员
     * @param query
     * @param condition
     * @return
     */
    List<Object> findManagerPage(Query<Object> query, Map<String, Object> condition);

    Integer addManager(Manager manager);

}
