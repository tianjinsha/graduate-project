package com.chengshi.qixingshe.core.validate.code;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.embedded.jetty.JettyServerCustomizer;

/**
 * 验证码
 * 
 * @author tian
 * @date 2018年11月26日
 */
@Data
public class ValidateCode  implements Serializable{
	/**
	 * 验证码内容
	 */
	private String code;
	/**
	 * 验证码过期时间
	 */
	private LocalDateTime expireTime;

	public ValidateCode(){}

	public ValidateCode(String code, LocalDateTime expireTime) {
		this.code = code;
		this.expireTime = expireTime;
	}

	public ValidateCode(String code, int expireSec) {
		this.code = code;
		this.expireTime = LocalDateTime.now().plusSeconds(expireSec);
	}

	/**
	 * 判断验证码是否过期
	 * 
	 * @return
	 */
	public boolean isExpried() {
		return LocalDateTime.now().isAfter(expireTime);
	}

}
