package com.fanchaojian.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fanchaojian
 * @date 2021-6-23 - 11:54
 */
@RestController
public class MyController {
    @GetMapping("/hello")
    public String hello(){
        return "this is my first springboot demo" ;
    }
}
