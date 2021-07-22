package com.fanchaojian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author fanchaojian
 * @date 2021-7-2 - 11:33
 */
@SpringBootApplication
@EnableFeignClients  //使用feign激活并开起
public class OrderFeignMain80 {
    public static void main(String[] args){
        SpringApplication.run(OrderFeignMain80.class,args) ;
    }
}
