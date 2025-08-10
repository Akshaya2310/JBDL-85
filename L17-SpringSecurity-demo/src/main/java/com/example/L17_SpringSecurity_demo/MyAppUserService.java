package com.example.L17_SpringSecurity_demo;

import jakarta.annotation.PostConstruct;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MyAppUserService implements UserDetailsService {

    Map<String,UserDetails> userStore = new HashMap<>();

    @PostConstruct
    public void init(){
        userStore.put("rahul", User.builder().username("rahul").password("rahul123").roles("USER").build());
        userStore.put("ravi", User.builder().username("ravi").password("ravi123").roles("USER").build());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = userStore.get(username);
        if(userDetails == null){
            throw new UsernameNotFoundException("User Does not exist");
        }
        return userDetails;
    }
    // read user from database
    // get user from some other service using API
    // get user from any external source
}
