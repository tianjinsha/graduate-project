package com.chengshi.qixingshe.security;

import com.chengshi.qixingshe.dao.ManagerMapper;
import com.chengshi.qixingshe.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;

/**
 * 获取登录用户的信息
 * 
 * @author tian
 * @date 2018年11月25日
 */
@Slf4j
@Component
public class BrowserUserDetailService implements UserDetailsService{

	@Autowired
	ManagerMapper managerMapper;

	/**
	 * 根据用户输入的用户名查询用户是否存在
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Manager manager=managerMapper.findManagerByAccount(username);
		log.info("密码登录："+username+manager.getPassword());
		if (manager==null){
			throw new UsernameNotFoundException(String.format("没有找到这个用户： '%s'.", username));
		}else{
			return  new User(manager.getAccount(),
					manager.getPassword(),
					manager.getRoles().stream().map(c -> new SimpleGrantedAuthority(c.getDescription())).collect(Collectors.toList()));
		}
	}
}
