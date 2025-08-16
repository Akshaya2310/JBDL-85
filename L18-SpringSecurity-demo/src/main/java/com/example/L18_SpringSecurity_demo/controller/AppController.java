package com.example.L18_SpringSecurity_demo.controller;

import com.example.L18_SpringSecurity_demo.entity.AppUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/hello")
    String getHello(@AuthenticationPrincipal AppUser appUser){
        //AppUser appUser = (AppUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Hello! "+appUser.getName()+"  - form "+Thread.currentThread().getName();
    }




}
// JSESSIONID=C305BFF6FC9CE12C0473F4B6C9E3424A
// JSESSIONID=C305BFF6FC9CE12C0473F4B6C9E3424A