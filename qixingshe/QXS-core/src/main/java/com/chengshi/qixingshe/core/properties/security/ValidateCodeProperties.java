package com.chengshi.qixingshe.core.properties.security;

import lombok.Data;

/**
 * 验证码相关的属性
 * 
 * @author tian
 * @date 2018年11月26日
 */
@Data
public class ValidateCodeProperties {

	private ImageCodeProperties image = new ImageCodeProperties();

	private SmsCodeProperties sms = new SmsCodeProperties();
}
