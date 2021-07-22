package com.fanchaojian.springcloud.controller;

import com.fanchaojian.springcloud.entity.CommonResult;
import com.fanchaojian.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fanchaojian
 * @date 2021-7-2 - 11:43
 */

@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService ;


    @GetMapping("/consumer/payment/{id}")
    public CommonResult getById(@PathVariable("id") Long id){
        return paymentFeignService.getById(id) ;
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //openfeign-ribbon,客户端一般默认等待1秒钟
        return paymentFeignService.paymentFeignTimeout() ;
    }
}
