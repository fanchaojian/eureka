package com.fanchaojian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author fanchaojian
 * @date 2021-7-1 - 15:36
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulMain {
    public static void main(String[] args){
        SpringApplication.run(OrderConsulMain.class,args) ;
    }
}
