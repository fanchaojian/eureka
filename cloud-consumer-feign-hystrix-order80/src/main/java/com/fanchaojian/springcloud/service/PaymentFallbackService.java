package com.fanchaojian.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * 统一对Feign管理的接口进行服务降级配置
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-------PaymentFallbackService fall back-paymentInfo_OK,哈哈哈" ;
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "-------PaymentFallbackService fall back-paymentInfo_timeout,哈哈哈" ;
    }
}
