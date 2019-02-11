package com.chengshi.qixingshe.core.validate.code.image;

import com.chengshi.qixingshe.core.validate.code.impl.AbstractValidateCodeProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;

/**
 * 图像验证码处理器
 *
 * @author tian
 * @date 2018年11月26日
 */
@Component("imageValidateCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {

    /**
     * 发送图形验证码，将其写到响应中
     */
    @Override
    protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
        ImageIO.write(imageCode.getBufferedImage(), "PNG", request.getResponse().getOutputStream());
    }

}
