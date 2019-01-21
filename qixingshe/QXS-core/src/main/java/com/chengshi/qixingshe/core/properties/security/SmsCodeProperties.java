package com.chengshi.qixingshe.core.properties.security;

import lombok.Data;

/**
 * 短信验证码的相关属性
 * @author tian
 * @date 2018年11月26日
 */
@Data
public class SmsCodeProperties {
	/**
	 * 验证码长度
	 */
	private int length = 6;
	/**
	 * 验证码过期时间
	 */
	private int expireIn = 60;
	/**
	 * 验证码的生成地址
	 */
	private String url;
}
