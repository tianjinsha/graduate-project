package com.chengshi.qixingshe.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * 验证码错误异常
 *
 * @author tian
 * @date 2018年11月26日
 */
public class ValidateCodeException extends AuthenticationException {

    /**
     *
     */
    private static final long serialVersionUID = 2389505142245811636L;

    public ValidateCodeException(String msg) {
        super(msg);
    }

}
