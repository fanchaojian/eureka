package com.fanchaojian.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author fanchaojian
 * @date 2021-7-2 - 15:17
 */
@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id){
        return "线程池： "+Thread.currentThread().getName()+"\t"+" paymentInfo_OK,id: "+id+"哈哈~" ;
    }

    //====服务降级

    @HystrixCommand(fallbackMethod="paymentInfo_timeoutHandler",commandProperties={
        @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
    })
    public String paymentInfo_timeout(Integer id){
        int i = 10/0 ;  //异常测试
        int timeNum = 3 ;  //超时测试
       /* try {
            TimeUnit.SECONDS.sleep(timeNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return "线程池： "+Thread.currentThread().getName()+" paymentInfo_timeout,id: "+id+"\t" +"耗时："+timeNum+"秒。" ;
    }

    public String paymentInfo_timeoutHandler(Integer id){
        return "线程池： "+Thread.currentThread().getName()+" paymentInfo_timeoutHandler,id: "+id+"\t" +" ...(╥╯^╰╥)..." ;
    }


    //====服务熔断
    /*
    HystrixCommandProperties：
    private final HystrixProperty<Integer> circuitBreakerRequestVolumeThreshold; // number of requests that must be made within a statisticalWindow before open/close decisions are made using stats
    private final HystrixProperty<Integer> circuitBreakerSleepWindowInMilliseconds; // milliseconds after tripping circuit before allowing retry
    private final HystrixProperty<Boolean> circuitBreakerEnabled; // Whether circuit breaker should be enabled.
    private final HystrixProperty<Integer> circuitBreakerErrorThresholdPercentage; // % of 'marks' that must be failed to trip the circuit
    */
    //在开启断路器的情况下，在一定的时间窗口期内请求的次数达到了10次，并且请求的失败率达到60%，就会采取服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback")
    public String paymentCircuitBreaker(Integer id){
        if(id<0){
            throw new RuntimeException("*****id 不能为负数") ;
        }
        String serialNumber = IdUtil.simpleUUID() ;
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNumber ;
    }

    public String paymentCircuitBreaker_fallback(Integer id){
        return "id 不能为负数，请稍后重试。id："+id ;
    }




}
