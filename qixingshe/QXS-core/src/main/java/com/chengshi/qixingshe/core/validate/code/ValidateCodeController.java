package com.chengshi.qixingshe.core.validate.code;

import com.chengshi.qixingshe.core.properties.security.SecurityConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tian
 * @date 2018年11月26日
 */
@RestController
@Slf4j
public class ValidateCodeController {

    public static final String SESSION_KEY = " SESSION_KEY_IMAGE_CODE";


    @Autowired
    private ValidateCodeProcessorHolder validateCodeProcessorHolder;


    @GetMapping(SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/{type}")
    public void createCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) throws Exception {
        validateCodeProcessorHolder.findValidateCodeProcessor(type).create(new ServletWebRequest(request, response));
    }

}
