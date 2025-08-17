package com.example.minor_project_01.service;

import com.example.minor_project_01.dto.PasswordReqDto;
import com.example.minor_project_01.dto.SignUpResponseDTO;
import com.example.minor_project_01.dto.UserDto;
import com.example.minor_project_01.entity.Role;
import com.example.minor_project_01.entity.User;
import com.example.minor_project_01.exception.NotFoundException;
import com.example.minor_project_01.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class PublicService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public SignUpResponseDTO createUser(UserDto userDto){

        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setRole(Role.CUSTOMER);
        userRepo.save(user);

        String token = UUID.randomUUID().toString();
        String key = "password:"+token;
        String value = userDto.getEmail();
        redisTemplate.opsForValue().set(key,value,2, TimeUnit.MINUTES);

        String resetUrl = "localhost:8080/public/password-reset/"+token;
        //Trigger Password Reset and Email Verification
        SignUpResponseDTO responseDTO = new SignUpResponseDTO();
        responseDTO.setMessage("User Created");
        responseDTO.setLink(resetUrl);
        return responseDTO;
    }

    public String resetPassword(PasswordReqDto passwordReqDto, String token) throws NotFoundException {
        String key = "password:"+token;
        String value = redisTemplate.opsForValue().get(key);
        if(value == null || !value.equals( passwordReqDto.getEmail())){
            throw new NotFoundException("Invalid Token");
        }
        User user = userRepo.findByEmail(passwordReqDto.getEmail());
        user.setPassword(passwordEncoder.encode(passwordReqDto.getNewPassword()));
        userRepo.save(user);
        return "Password Updated";
    }


}
