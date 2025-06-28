package com.example.L07_Spring_Boot_demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {


    @GetMapping("/hello")
    public String hello(@RequestParam String name){
        return "Hello "+name+", from :"+Thread.currentThread().getName();
    }
}
