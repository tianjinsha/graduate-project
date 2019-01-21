package com.chengshi.qixingshe.service;

import com.chengshi.qixingshe.model.Userinfo;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2018-12-01
 */
public interface IUserinfoService extends IService<Userinfo> {

    /**
     * 根据id查找用户新
     * @param id
     * @return
     */
    Userinfo findUserInfoById(int id);

    /**
     * 根据用户Id查找用户信息
     * @param userId
     * @return
     */
    Userinfo findUserInfoByUserId(int userId);

    /**
     * 添加用户信息
     * @param userinfo
     * @return
     */
    Boolean addUserInfo(Userinfo userinfo);
    /**
     * 修改用户信息
     * @param userinfo
     * @return
     */
    Boolean updateUserInfo(Userinfo userinfo);

}
