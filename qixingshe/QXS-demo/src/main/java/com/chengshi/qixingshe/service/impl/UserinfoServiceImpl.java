package com.chengshi.qixingshe.service.impl;

import com.chengshi.qixingshe.model.Userinfo;
import com.chengshi.qixingshe.dao.UserinfoMapper;
import com.chengshi.qixingshe.service.IUserinfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-01
 */
@Service
public class UserinfoServiceImpl extends ServiceImpl<UserinfoMapper, Userinfo> implements IUserinfoService {

    @Autowired
    UserinfoMapper userinfoMapper;

    @Override
    public Userinfo findUserInfoById(int id) {
        Userinfo userinfo=new Userinfo();
        userinfo.setId(id);
        return userinfoMapper.selectOne(userinfo);
    }

    @Override
    public Userinfo findUserInfoByUserId(int userId) {
        Userinfo userinfo=new Userinfo();
        userinfo.setUserId(userId);
        return userinfoMapper.selectOne(userinfo);
    }

    @Override
    public Boolean addUserInfo(Userinfo userinfo) {
        return null;
    }

    @Override
    public Boolean updateUserInfo(Userinfo userinfo) {
        return null;
    }
}
