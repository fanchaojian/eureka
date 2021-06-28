package com.fanchaojian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author fanchaojian
 * @date 2021-6-24 - 17:05
 */
@SpringBootApplication
@EnableEurekaServer   //标记我是服务注册中心
public class EurekaMain7001 {
    public static void main(String[] args){
        SpringApplication.run(EurekaMain7001.class,args) ;
    }
}
