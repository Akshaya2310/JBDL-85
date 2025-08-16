package com.example.L18_SpringSecurity_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping("/blog")
    public String getBlog(){
        return "Blog content : from -"+Thread.currentThread().getName();
    }

}
