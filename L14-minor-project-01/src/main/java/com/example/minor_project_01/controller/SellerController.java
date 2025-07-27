package com.example.minor_project_01.controller;


import com.example.minor_project_01.dto.CreateResponseDTO;
import com.example.minor_project_01.dto.ProductDTO;
import com.example.minor_project_01.dto.ResponseDTO;
import com.example.minor_project_01.exception.NotFoundException;
import com.example.minor_project_01.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping("/product")
    public ResponseEntity<CreateResponseDTO> createProduct(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(sellerService.createProduct(productDTO));
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductDTO>> getProducts(){
        return ResponseEntity.ok(sellerService.getProducts());
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ResponseDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(sellerService.updateProduct(id,productDTO));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<ResponseDTO> deleteProduct(@PathVariable Long id) throws NotFoundException {
        return ResponseEntity.ok(sellerService.deleteProduct(id));
    }

//    @PutMapping("/order/{id}/accept")
//    public ResponseEntity<ResponseDTO>  submitOrder(@PathVariable Long id){
//
//    }


}
