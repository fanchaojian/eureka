package com.fanchaojian.springcloud.controller;

import com.fanchaojian.springcloud.entity.CommonResult;
import com.fanchaojian.springcloud.entity.Payment;
import com.sun.media.jfxmedia.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author fanchaojian
 * @date 2021-6-23 - 16:59
 */
@RestController
public class OrderController {

    //public static final String PAYMENT_URL = "http://localhost:8001" ;  提供者单机版
    public static final String PAYMENT_URL = "http://cloud-payment-service" ;   //提供者集群版

    @Autowired
    private RestTemplate restTemplate  ;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class) ;
    }

    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/"+id,CommonResult.class) ;
    }

    @GetMapping("/hello")
    public String test(){
        return "haahaahha" ;
    }
}
