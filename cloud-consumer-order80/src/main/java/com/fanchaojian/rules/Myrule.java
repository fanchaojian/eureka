package com.fanchaojian.rules;

/**
 * @author fanchaojian
 * @date 2021-7-1 - 17:30
 */

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 切换ribbon算法
 * 注意：此配置类务必需要在@ComponentScan扫描不到的地方配置
 * @ComponentScan
 * @SpringBootApplication 下的一个注解，意思是扫描本包或本包下的子包
 * 所以我们的算法配置类需要配置在com.fanchaojian.springcloud包之外
 */
@Configuration
public class Myrule {
    @Bean
    public IRule myRule(){
        return new RandomRule() ;
    }
}
