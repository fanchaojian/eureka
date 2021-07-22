package com.fanchaojian.springcloud.controller;

import com.fanchaojian.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fanchaojian
 * @date 2021-7-2 - 17:13
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class PaymentHystrixController {
    @Autowired
    private PaymentHystrixService paymentHystrixService ;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_OK(id) ;
    }

    /*@GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_timeout(id) ;
    }*/

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    //专属独用hystrix配置
    /*@HystrixCommand(fallbackMethod="paymentInfo_timeoutHandler",commandProperties={
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
    })*/
    //公共的配置
    //@HystrixCommand
    public String paymentInfo_timeout(@PathVariable("id") Integer id) {
        /*int i = 10/0 ;*/
        return paymentHystrixService.paymentInfo_timeout(id) ;

    }

    public String paymentInfo_timeoutHandler(Integer id){
        return "我是客户端80，服务端异常或自行运行出错，请重试 ...(╥╯^╰╥)..." ;
    }

    //全局fallback方法
    public String payment_Global_FallbackMethod(){
        return "hystrix全局服务降级处理信息返回，哈哈哈" ;
    }




}
