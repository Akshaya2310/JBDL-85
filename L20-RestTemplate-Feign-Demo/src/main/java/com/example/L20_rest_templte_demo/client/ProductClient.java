package com.example.L20_rest_templte_demo.client;

import com.example.L20_rest_templte_demo.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductClient {


    @PostMapping("/product")
    ProductDto createProduct(@RequestBody ProductDto product, @RequestHeader(required = false) String requestId);

    @GetMapping("/product/list")
    List<ProductDto> getAllProduct();

}
/*
product-service => 5 instances

 */
