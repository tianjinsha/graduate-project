package com.chengshi.qixingshe.core.validate.code.sms;

import com.chengshi.qixingshe.core.properties.MineProperties;
import lombok.Data;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import com.chengshi.qixingshe.core.properties.security.SecurityProperties;
import com.chengshi.qixingshe.core.validate.code.ValidateCode;
import com.chengshi.qixingshe.core.validate.code.ValidateCodeGenerator;

/**
 * 短信验证码生成器
 * @author tian
 * @date 2018年11月27日
 */
@Data
@Component("smsValidateCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

	@Autowired
	private MineProperties mineProperties;
	
	@Override
	public ValidateCode generate(ServletWebRequest servletWebRequest) {
		String code = RandomStringUtils.randomNumeric(mineProperties.getSecurity().getCode().getSms().getLength());
		return new ValidateCode(code, mineProperties.getSecurity().getCode().getSms().getExpireIn());
	}
	

}
