package com.example.L18_SpringSecurity_demo.controller;

import com.example.L18_SpringSecurity_demo.MyAppUserService;
import com.example.L18_SpringSecurity_demo.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private MyAppUserService appUserService;


    @GetMapping("/hello")
    String getHello(@AuthenticationPrincipal AppUser appUser){
        //AppUser appUser = (AppUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Hello ADMIN "+appUser.getName()+"  - form "+Thread.currentThread().getName();
    }

    @PostMapping("/createUser")
    String createUser(@RequestBody AppUser appUser){
        return appUserService.createUser(appUser);
    }


    @GetMapping("/changePassword")
    public ResponseEntity<String> changePassword(@AuthenticationPrincipal AppUser appUser, @RequestParam String newPassword){
        appUserService.changePassword(appUser,newPassword);
        return ResponseEntity.ok("Password changed");
    }

}
