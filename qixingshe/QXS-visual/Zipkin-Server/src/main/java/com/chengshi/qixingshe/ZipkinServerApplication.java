package com.chengshi.qixingshe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

/**
 * @description:
 * @author: tian
 * @date: 2018-12-06 10:05
 */
//@EnableZipkinServer
@EnableZipkinStreamServer
@EnableDiscoveryClient
@SpringBootApplication
public class ZipkinServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerApplication.class, args);
    }

}
