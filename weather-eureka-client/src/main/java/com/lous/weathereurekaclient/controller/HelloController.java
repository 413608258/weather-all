package com.lous.weathereurekaclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : HelloController
 * @Description :
 *
 * @author : Loushuai
 * @since : 2019-01-09
 **/
 @RestController
public class HelloController {

     @GetMapping("/hello")
     public String hello(){
         return "Hello Eureka Client...";
     }
}
