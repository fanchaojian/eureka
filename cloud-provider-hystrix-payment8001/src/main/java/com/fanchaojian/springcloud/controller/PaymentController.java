package com.fanchaojian.springcloud.controller;

import com.fanchaojian.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author fanchaojian
 * @date 2021-7-2 - 15:22
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService ;

    @Value("${server.port}")
    private String serverPort ;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable Integer id){
        return paymentService.paymentInfo_OK(id) ;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable Integer id){
        return paymentService.paymentInfo_timeout(id);
    }

    @GetMapping("/payment/hystrixCircuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        return paymentService.paymentCircuitBreaker(id) ;
    }
}
