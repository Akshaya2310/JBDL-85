package com.example.minor_project_01.controller;

import com.example.minor_project_01.dto.PasswordReqDto;
import com.example.minor_project_01.dto.ProductDTO;
import com.example.minor_project_01.dto.SignUpResponseDTO;
import com.example.minor_project_01.dto.UserDto;
import com.example.minor_project_01.exception.NotFoundException;
import com.example.minor_project_01.service.CustomerService;
import com.example.minor_project_01.service.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PublicService publicService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getProductsByKeyword(@RequestParam String keyword, @RequestParam Integer pageSize, @RequestParam Integer pageNo){
        Pageable pageable = Pageable.ofSize(pageSize)
                .withPage(pageNo);
        return ResponseEntity.ok(customerService.getProductByKeyword(keyword,pageable));
    }


    @PostMapping("/signup")
    ResponseEntity<SignUpResponseDTO> createCustomerUser(@RequestBody UserDto userDto){
        SignUpResponseDTO responseDto = publicService.createUser(userDto);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/password-reset/{token}")
    ResponseEntity<String> resetPassword(@RequestBody PasswordReqDto passwordReqDto, @PathVariable String token) throws NotFoundException {
        String response = publicService.resetPassword(passwordReqDto,token);
        return ResponseEntity.ok(response);
    }




}
