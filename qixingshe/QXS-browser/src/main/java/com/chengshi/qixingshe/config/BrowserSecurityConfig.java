package com.chengshi.qixingshe.config;

import javax.sql.DataSource;

import com.chengshi.qixingshe.core.properties.MineProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.chengshi.qixingshe.core.authentication.AbstractChannelSecurityConfig;
import com.chengshi.qixingshe.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.chengshi.qixingshe.core.properties.security.SecurityConstants;
import com.chengshi.qixingshe.core.properties.security.SecurityProperties;
import com.chengshi.qixingshe.core.validate.code.ValidateCodeSecurityConfig;

/**
 * 浏览器安全配置
 * @author tian
 * @date 2018年11月26日
 */
@Configuration
public class BrowserSecurityConfig extends AbstractChannelSecurityConfig{
	
	/**
	 * 数据源	
	 */
	@Autowired
	private DataSource dataSource;
	
	/**
	 * 系统安全配置
	 */
	@Autowired
	private MineProperties mineProperties;
	
	/**
	 * 验证码配置器
	 */
	@Autowired
	private ValidateCodeSecurityConfig validateCodeSecurityConfig;
	/**
	 * 短信验证码配置器
	 */
	@Autowired
	private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
	
	/**
	 * 用户信息
	 */
	@Autowired
	private UserDetailsService userDetailsService;

	/**
	 * 加密
	 */
	@Autowired
	private PasswordEncoder passwordEncoder;


	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
//		tokenRepository.setCreateTableOnStartup(true);
		return tokenRepository;
	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	/**
	 * spring security 安全配置
	 * 配置登录选项
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		applyPasswordAuthenticationConfig(http);
		
		http.apply(validateCodeSecurityConfig)
		.and()
			.apply(smsCodeAuthenticationSecurityConfig)
		.and()
			.rememberMe()
			.tokenRepository(persistentTokenRepository())
			.tokenValiditySeconds(mineProperties.getSecurity().getBrowser().getRememberMeSeconds())
			.userDetailsService(userDetailsService)
		.and()
			.authorizeRequests()
			.antMatchers(
					SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
					SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
					mineProperties.getSecurity().getBrowser().getLoginPage(),
					SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/*",
					mineProperties.getSecurity().getBrowser().getSignUpUrl()
					,"/login.css","/images/**","/lib/**","/css/*","/js/*")
			.permitAll() //不需要认证的服务
			.anyRequest()
			.authenticated()
		.and()
			.headers().frameOptions().disable()
		.and()
		.csrf().disable();//关闭跨站维护
		
	}

	
}
