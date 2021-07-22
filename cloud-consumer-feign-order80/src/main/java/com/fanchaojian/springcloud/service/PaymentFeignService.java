package com.fanchaojian.springcloud.service;

import com.fanchaojian.springcloud.entity.CommonResult;
import com.fanchaojian.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author fanchaojian
 * @date 2021-7-2 - 11:37
 */
@Component
//注册到eureka上的服务名称
@FeignClient(value="cloud-payment-service")
public interface PaymentFeignService {
    @GetMapping("/payment/{id}")
    public CommonResult getById(@PathVariable("id") Long id) ;

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();
}
