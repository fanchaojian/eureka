package com.fanchaojian.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author fanchaojian
 * @date 2021-7-1 - 13:39
 */
@RestController
@Slf4j
public class OrderZKController {
    public static final String INVOKE_URL = "http://cloud-provider-payment" ;

    @Resource
    private RestTemplate restTemplate ;

    @GetMapping("/consumer/payment/zk")
    public String paymentInfo(){
       return restTemplate.getForObject("http://cloud-provider-payment"+"/payment/zk",String.class) ;
    }
}
