package com.example.L18_SpringSecurity_demo;

import com.example.L18_SpringSecurity_demo.entity.AppUser;
import com.example.L18_SpringSecurity_demo.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyAppUserService implements UserDetailsService {

//    Map<String,UserDetails> userStore = new HashMap<>();
//
//    @PostConstruct
//    public void init(){
//        userStore.put("rahul", User.builder().username("rahul").password("$2a$10$HUQEtO8kv4e20ToykS/iEelRe3u5RvRUZukF5tqiKllZ/46205ab6").roles("USER").build());
//        userStore.put("ravi", User.builder().username("ravi").password("$2a$10$skE1C7Rgc26We.YobGdFZ.IRBcSFtFO2m0dpUW7bvseU7dshYDoTe").roles("USER").build());
//    }

    @Autowired
    private AppUserRepo appUserRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String createUser(AppUser appUser){
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUserRepo.save(appUser);
        return "User Created";
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepo.findByEmail(username);
        if(appUser == null){
            throw new UsernameNotFoundException("User Does not exist");
        }
        return appUser;
    }
    // read user from database
    // get user from some other service using API
    // get user from any external source

    public boolean changePassword(AppUser appUser, String newPassword){
        appUser.setPassword(passwordEncoder.encode(newPassword));
        appUser = appUserRepo.save(appUser);
        return true;
    }
}
