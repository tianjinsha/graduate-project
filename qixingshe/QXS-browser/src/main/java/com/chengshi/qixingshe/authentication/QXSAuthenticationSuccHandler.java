package com.chengshi.qixingshe.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chengshi.qixingshe.core.properties.MineProperties;
import com.chengshi.qixingshe.core.properties.security.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.chengshi.qixingshe.core.properties.security.LoginResponseType;
import com.chengshi.qixingshe.core.properties.security.SecurityProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * 登录成功后的操作
 * @author tian
 * @date 2018年11月26日
 */
@Slf4j
@Component(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
public class QXSAuthenticationSuccHandler extends SavedRequestAwareAuthenticationSuccessHandler{

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MineProperties mineProperties;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
//		super.onAuthenticationSuccess(request, response, authentication);
		log.info("登录成功");
		
		if (LoginResponseType.JSON.equals(mineProperties.getSecurity().getBrowser().getLoginType())) {
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(objectMapper.writeValueAsString(authentication));
		} else {
			super.onAuthenticationSuccess(request, response, authentication);
		}
	}

	
}
