package com.chengshi.qixingshe.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chengshi.qixingshe.model.Authority;
import com.chengshi.qixingshe.model.Manager;
import com.chengshi.qixingshe.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2018-12-01
 */
@Repository
public interface AuthorityMapper extends BaseMapper<Authority> {

    int insertAuthority(int userId, int roleId);

    List<Role> findRolesByUserId(Integer id);

    List<Manager> findManagersByRoleId(Integer id);
}
