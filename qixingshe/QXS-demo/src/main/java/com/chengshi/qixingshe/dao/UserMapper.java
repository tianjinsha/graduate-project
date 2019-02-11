package com.chengshi.qixingshe.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chengshi.qixingshe.core.common.util.Query;
import com.chengshi.qixingshe.model.User;
import org.apache.ibatis.annotations.Param;

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
public interface UserMapper extends BaseMapper<User> {

    int add(User user);

    int update(User user);

    /**
     * 恢复数据
     *
     * @param id
     * @return
     */
    int recover(int id);

    /**
     * 改变数据的状态
     *
     * @param id
     * @param status
     * @return
     */
    int updateStatus(@Param("id") int id, @Param("status") String status);

    int delete(int id);

    User findUser(int id);

    List<User> findUserList();

    /**
     * @param query     查询对象
     * @param condition 查询条件
     * @return
     * @Description 分页查询
     */
    List<Object> findUserPage(Query<Object> query, Map<String, Object> condition);

    /**
     * @param query     查询对象
     * @param condition 查询条件
     * @return
     * @Description 分页查询本删除的记录
     */
    List<Object> findUserPageDel(Query<Object> query, Map<String, Object> condition);

    /**
     * 批量失效用户 0
     *
     * @param ids
     * @return
     */
    Integer batchDisable(@Param("ids") List<Integer> ids);

    /**
     * 批量恢复用户 2
     *
     * @param ids
     * @return
     */
    Integer batchRecover(@Param("ids") List<Integer> ids);

}
