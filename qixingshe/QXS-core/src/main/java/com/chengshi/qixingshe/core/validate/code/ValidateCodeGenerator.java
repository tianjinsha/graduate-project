package com.chengshi.qixingshe.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 验证码生成器
 * @author tian
 * @date 2018年11月26日
 */
public interface ValidateCodeGenerator {
	
	public ValidateCode generate(ServletWebRequest servletWebRequest);
}
