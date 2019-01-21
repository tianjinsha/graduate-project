package com.chengshi.qixingshe.core.properties.security;

import lombok.Data;

@Data
public class BrowserProperties {
	/**
	 * 个人登录页面
	 */
	private String loginPage = SecurityConstants.DEFAULT_LOGIN_PAGE_URL;

	/**
	 * 个人注销页面
	 */
	private String signUpUrl = SecurityConstants.DEFAULT_LOGOUT_PAGE_URL;

	/**
	 * 登录响应类型
	 */
	private LoginResponseType loginType = LoginResponseType.JSON;
	/**
	 * 记住我的秒数
	 */
	private int rememberMeSeconds = 3600;

}
