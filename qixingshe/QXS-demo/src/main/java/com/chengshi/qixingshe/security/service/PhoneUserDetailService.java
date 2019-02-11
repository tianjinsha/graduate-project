package com.chengshi.qixingshe.security.service;

import com.chengshi.qixingshe.dao.ManagerMapper;
import com.chengshi.qixingshe.model.Manager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * 获取登录用户的信息
 *
 * @author tian
 * @date 2018年11月25日
 */
@Slf4j
@Component("phoneUserDetailService")
public class PhoneUserDetailService implements UserDetailsService {

    @Autowired
    ManagerMapper managerMapper;

    /**
     * 根据用户输入的电话号码查询用户是否存在
     */
    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        Manager manager = managerMapper.findManagerByPhone(phone);
        log.info("短信登录：" + phone + manager.getPassword());
        if (manager == null) {
            throw new UsernameNotFoundException(String.format("没有找到这个用户： '%s'.", phone));
        } else {
            return new User(manager.getAccount(),
                    manager.getPassword(),
                    manager.getRoles().stream().map(c -> new SimpleGrantedAuthority(c.getDescription())).collect(Collectors.toList()));
        }
    }
}
