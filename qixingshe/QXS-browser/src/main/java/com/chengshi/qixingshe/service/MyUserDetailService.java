package com.chengshi.qixingshe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 获取登录用户的信息
 * 
 * @author tian
 * @date 2018年11月25日
 */
@Slf4j
@Component
public class MyUserDetailService implements UserDetailsService{
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	/**
	 * 根据用户输入的用户名查询用户是否存在
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String password=passwordEncoder.encode("123456");
		User user=new User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
		log.info("用户名："+username);
		log.info("密码"+user.getPassword());
		return user;
	}

}
