package com.chengshi.qixingshe.core.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.chengshi.qixingshe.core.properties.security.SecurityConstants;

/**
 * 用户名密码登录的相关配置
 * @author tian
 * @date 2018年11月27日
 */
public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter{

	/**
	 * 成功处理器
	 */
	@Autowired
	private AuthenticationSuccessHandler authenticationSuccHandler;

	/**
	 * 失败处理器
	 */
	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler;
	
	protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
		http.formLogin()
			.loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
			.loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
			.successHandler(authenticationSuccHandler)
			.failureHandler(authenticationFailureHandler);
	}
}
