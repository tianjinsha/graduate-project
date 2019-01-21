package com.chengshi.qixingshe.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @description:
 * @author: tian
 * @date: 2018-12-20 20:43
 */
//@Configuration
public class ErrorPageConfig {

//    @Autowired
//    private MineProperties mineProperties;

//    @Bean
//    public EmbeddedServletContainerCustomizer containerCustomizer() {
//        return new EmbeddedServletContainerCustomizer() {
//            @Override
//            public void customize(ConfigurableEmbeddedServletContainer container) {
//                ErrorPage error400Page = new ErrorPage(HttpStatus.BAD_REQUEST, "/400.html");
//                ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
//                ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, mineProperties.getCommon().getErrorPage().getErr404());
//                ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, mineProperties.getCommon().getErrorPage().getErr500());
//                container.addErrorPages(error400Page, error401Page, error404Page, error500Page);
//            }
//        };
//    }
}
