package com.example.L13_minor_project_01.controller;


import com.example.L13_minor_project_01.dto.CreateResponseDTO;
import com.example.L13_minor_project_01.dto.ProductDTO;
import com.example.L13_minor_project_01.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping("/product")
    public ResponseEntity<CreateResponseDTO> createProduct(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(sellerService.createProduct(productDTO));
    }

}
