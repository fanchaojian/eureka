package com.fanchaojian.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author fanchaojian
 * @date 2021-6-23 - 17:09
 */
@Configuration
public class ApplicationContextConfig {

    //注册restTemplate调用提供者
    @Bean
    @LoadBalanced   //使用此注解赋予RestTemplate负载均衡的能力，这样才能通过微服务名称调用服务
    public RestTemplate getRestTemplate(){
        return new RestTemplate() ;
    }
}
