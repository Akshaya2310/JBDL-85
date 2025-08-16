package com.example.minor_project_01.controller;

import com.example.minor_project_01.dto.ProductDTO;
import com.example.minor_project_01.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getProductsByKeyword(@RequestParam String keyword, @RequestParam Integer pageSize, @RequestParam Integer pageNo){
        Pageable pageable = Pageable.ofSize(pageSize)
                .withPage(pageNo);
        return ResponseEntity.ok(customerService.getProductByKeyword(keyword,pageable));
    }
}
