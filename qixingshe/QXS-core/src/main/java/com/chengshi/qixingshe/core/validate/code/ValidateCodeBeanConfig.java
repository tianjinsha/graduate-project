package com.chengshi.qixingshe.core.validate.code;

import com.chengshi.qixingshe.core.properties.MineProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.chengshi.qixingshe.core.properties.security.SecurityProperties;
import com.chengshi.qixingshe.core.validate.code.image.ImageCodeGenerator;
import com.chengshi.qixingshe.core.validate.code.sms.DefaultSmsCodeSender;
import com.chengshi.qixingshe.core.validate.code.sms.SmsCodeSender;

/**
 * 验证码配置器
 * 
 * @author tian
 * @date 2018年11月26日
 */
@Configuration
public class ValidateCodeBeanConfig {
	@Autowired
	private MineProperties mineProperties;

	@Bean
	@ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
	public ValidateCodeGenerator imageValidateCodeGenerator() {
		ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
		codeGenerator.setMineProperties(mineProperties);
		return codeGenerator;
	}
	
	@Bean
	@ConditionalOnMissingBean(SmsCodeSender.class)
	public SmsCodeSender smsCodeSender() {
		return new DefaultSmsCodeSender();
	}
}
