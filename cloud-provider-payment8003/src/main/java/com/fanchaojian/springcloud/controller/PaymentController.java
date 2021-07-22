package com.fanchaojian.springcloud.controller;

import com.fanchaojian.springcloud.entity.CommonResult;
import com.fanchaojian.springcloud.entity.Payment;
import com.fanchaojian.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author fanchaojian
 * @date 2021-6-23 - 14:23
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService ;

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

    //feign 超时测试
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort.toString();
    }
}
