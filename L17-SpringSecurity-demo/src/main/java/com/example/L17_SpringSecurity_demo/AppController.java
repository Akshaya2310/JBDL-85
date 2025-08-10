package com.example.L17_SpringSecurity_demo;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/hello")
    String getHello(){
        return "Hello! form "+Thread.currentThread().getName();
    }
}
// JSESSIONID=C305BFF6FC9CE12C0473F4B6C9E3424A
// JSESSIONID=C305BFF6FC9CE12C0473F4B6C9E3424A