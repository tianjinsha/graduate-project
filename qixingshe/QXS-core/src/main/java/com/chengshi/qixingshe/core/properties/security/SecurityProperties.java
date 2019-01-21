package com.chengshi.qixingshe.core.properties.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * 权限相关的相关属性
 * @author tian
 * @date 2018年11月26日
 */
@Data
public class SecurityProperties {
	/**
	 * 浏览器属性
	 */
	private BrowserProperties browser = new BrowserProperties();
	
	/**
	 * 验证码属性
	 */
	private ValidateCodeProperties code=new ValidateCodeProperties();
}
