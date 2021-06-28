package com.fanchaojian.springcloud.controller;

import com.fanchaojian.springcloud.entity.CommonResult;
import com.fanchaojian.springcloud.entity.Payment;
import com.fanchaojian.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fanchaojian
 * @date 2021-6-23 - 14:23
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService ;

    //服务发现，获取注册到eureka上是服务信息
    @Resource
    private DiscoveryClient discoveryClient ;

    //@value 标签可以在配置文件中获取值
    @Value("${server.port}")
    private Integer serverPort ;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int i = paymentService.create(payment);

        if(i > 0){
            return new CommonResult<>(200,"插入数据成功，serverPort："+serverPort,i) ;
        }else{
            return new CommonResult<>(400,"插入数据失败") ;
        }
    }

    @GetMapping("/payment/{id}")
    public CommonResult getById(@PathVariable("id") Long id){

        Payment pm = paymentService.getPaymentById(id);
        return new CommonResult<>(200,"查找数据成功，serverPort："+serverPort,pm) ;
    }

    //服务发现，获取服务基本信息，可作为微服务使用说明书发布
    @GetMapping("/payment/discovery")
    public Object discovery(){

        //获取注册到eureka上的微服务
        List<String> services = discoveryClient.getServices();
        for (String element : services ) {
            log.info("*****element："+element);
        }

        //获取指定的服务名称下的实例
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances ) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient ;
    }


}
