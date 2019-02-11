package com.chengshi.qixingshe.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: tian
 * @date: 2018-12-06 10:25
 */
@Controller
@RequestMapping("/eureka1")
@ResponseBody
public class DcController {
    org.slf4j.Logger logger = LoggerFactory.getLogger(DcController.class);
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/consumer")
    public String dc1() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client-2");
        String url = "http://" + ":" + serviceInstance.getPort() + "/dc";
        logger.info("url:" + url);
        logger.info("======<call trace 1>=======");
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/dc")
    public String dc() {
        String services = "Services: " + discoveryClient.getServices();
        logger.info("url:" + services);
        logger.info("======<call trace 1>=======");
        return services;
    }
}
