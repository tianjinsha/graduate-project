package com.chengshi.qixingshe.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chengshi.qixingshe.core.common.util.Query;
//import com.chengshi.qixingshe.core.properties.MineProperties;
import com.chengshi.qixingshe.dao.UserMapper;
import com.chengshi.qixingshe.model.User;
import com.chengshi.qixingshe.service.IUserService;
import com.chengshi.qixingshe.util.support.UserSupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-01
 */
@Slf4j
@Service
@CacheConfig(cacheNames="user",keyGenerator = "keyGenerator")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    UserMapper userMapper;
//    MineProperties mineProperties;

    @Override
    @Cacheable(key="'id:'+#p0")
    public User findUserById(Integer id) {
        return userMapper.findUser(id);
    }

    @Override
    @Cacheable(key="'userList'")
    public List<User> findUserList() {
        return userMapper.findUserList();
    }

    @Override
    public Page findUserPage(Query<Object> query, EntityWrapper<User> wrapper) {
        query.setSize(10);
        query.setRecords(userMapper.findUserPage(query, query.getCondition()));
        return query;

    }

    @Override
    public Page findUserPageDelete(Query<Object> query, EntityWrapper<User> wrapper) {
        query.setSize(10);
        query.setRecords(userMapper.findUserPageDel(query, query.getCondition()));
        return query;
    }

    @Override
    @CachePut(key="'id'+#p0")
    public Boolean addUser(User user) {
        user.setCreateTime(new Date());
        int count = userMapper.add(user);
        if (count == 1)
            return true;
        return false;
    }

    @Override
    @CacheEvict(key="'id:'+#p0")
    public Boolean deleteUser(Integer id) {
        int count = userMapper.delete(id);
        if (count == 1)
            return true;
        return false;
    }

    @Override
    @CachePut(key="'id:'+#p0")
    public Boolean recoverUser(Integer id) {
        int count=userMapper.updateStatus(id,"1");
        if (count == 1)
            return true;
        return false;
    }

    @Override
    @CachePut(key="'id:'+#p0")
    public Boolean stopUser(Integer id) {
        int count=userMapper.updateStatus(id,"2");
        if (count == 1)
            return true;
        return false;
    }

    @Override
    @CachePut(key="'id:'+#p0")
    public Boolean disableUser(Integer id) {
        int count=userMapper.updateStatus(id,"0");
        if (count == 1)
            return true;
        return false;
    }

    @Override
    @CachePut(key="'id:'+#p0.id")
    public Boolean modifyUser(User user) {
        user.setUpdateTime(new Date());
        int count = userMapper.update(user);
        if (count == 1)
            return true;
        return false;
    }

    @Override
    public Boolean batchDisableUser(List<Integer> ids) {
        int count=userMapper.batchDisable(ids);
        if (count == ids.size())
            return true;
        return false;
    }

    @Override
    public Boolean batchRecoverUser(List<Integer> ids) {
        int count =userMapper.batchRecover(ids);
        if (count == ids.size())
            return true;
        return false;
    }
}
