package com.chengshi.qixingshe.security.validate.sms;

import com.chengshi.qixingshe.core.properties.security.SecurityProperties;
import com.chengshi.qixingshe.core.validate.code.sms.SmsCodeSender;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @program: qixingshe
 * @author: tian
 * @description:
 * @date: 2019/2/3 9:45
 */
@Slf4j
//@Component("smsCodeSender")
public class TencentSmsCodeSender  implements SmsCodeSender {

    @Autowired
    SecurityProperties securityProperties;

    @Override
    public void send(String mobile, String code) {

        int appid = securityProperties.getCode().getSms().getAppId();
        String appkey = securityProperties.getCode().getSms().getAppKey();
        int templateId=securityProperties.getCode().getSms().getTemplateId();
        String smsSign = securityProperties.getCode().getSms().getSmsSign();
        try {
            String[] params = {code,String.valueOf(securityProperties.getCode().getSms().getExpireIn())};
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            // 签名参数未提供或者为空时，会使用默认签名发送短信
            SmsSingleSenderResult result = ssender.sendWithParam("86",mobile,
                    templateId, params, smsSign, "", "");
            log.info("短信验证码："+code);
            log.info(result.toString());
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }

    }
}
