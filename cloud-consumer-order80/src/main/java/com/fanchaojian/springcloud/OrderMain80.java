package com.fanchaojian.springcloud;

import com.fanchaojian.rules.Myrule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author fanchaojian
 * @date 2021-6-23 - 17:24
 *
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="cloud-payment-service",configuration = Myrule.class)  //在启动该微服务的时候能去加载我们的自定义Ribbon配置类，从而使配置生效.
public class OrderMain80 {
    public static void main(String[] args){
        SpringApplication.run(OrderMain80.class,args) ;
    }
}
