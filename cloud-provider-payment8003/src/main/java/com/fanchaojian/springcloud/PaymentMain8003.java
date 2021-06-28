package com.fanchaojian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author fanchaojian
 * @date 2021-6-25 - 14:55
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8003 {
    public static void main(String[] args){
        SpringApplication.run(PaymentMain8003.class,args) ;
    }
}
