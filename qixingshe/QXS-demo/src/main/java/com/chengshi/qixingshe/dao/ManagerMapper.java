package com.chengshi.qixingshe.dao;

import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.Manager;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2018-12-01
 */
public interface ManagerMapper extends BaseMapper<Manager> {


    /**
     * 更具用户id查找用户
     * @param id
     * @return
     */
    Manager findManagerById(int id);

    Manager findManagerByAccount(String account);

    Manager findManagerByPhone(String Phone);

    List<Object> findManagerPage(Query<Object> query, Map<String, Object> condition);

    Integer addManager(Manager manager);

}
