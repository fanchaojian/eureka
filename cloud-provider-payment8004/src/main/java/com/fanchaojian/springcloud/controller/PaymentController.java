package com.fanchaojian.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author fanchaojian
 * @date 2021-6-30 - 17:11
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort ;

    @RequestMapping("/payment/zk")
    public String paymentzk(){
        return "springcloud with zookeeper: "+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
