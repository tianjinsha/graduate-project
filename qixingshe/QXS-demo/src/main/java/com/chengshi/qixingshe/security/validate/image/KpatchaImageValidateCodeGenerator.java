package com.chengshi.qixingshe.security.validate.image;


import com.chengshi.qixingshe.core.properties.security.SecurityProperties;
import com.chengshi.qixingshe.core.validate.code.ValidateCode;
import com.chengshi.qixingshe.core.validate.code.ValidateCodeGenerator;
import com.chengshi.qixingshe.core.validate.code.image.ImageCode;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import java.awt.image.BufferedImage;


/**
 * @author
 * @description
 * @date 2019-2-3 12:29
 */
@Slf4j
@Component("imageValidateCodeGenerator")
public class KpatchaImageValidateCodeGenerator implements ValidateCodeGenerator {


    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private DefaultKaptcha captchaProducer;

    @Override
    public ValidateCode generate(ServletWebRequest servletWebRequest) {
        String sRand = captchaProducer.createText();
        log.info(sRand);
        BufferedImage image = captchaProducer.createImage(sRand);
        return new ImageCode(image, sRand, securityProperties.getCode().getImage().getExpireIn());
    }
}
