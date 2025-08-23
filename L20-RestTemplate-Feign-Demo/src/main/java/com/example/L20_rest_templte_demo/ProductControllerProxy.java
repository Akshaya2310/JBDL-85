package com.example.L20_rest_templte_demo;

import com.example.L20_rest_templte_demo.client.ProductClient;
import com.example.L20_rest_templte_demo.dto.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/product-proxy")
public class ProductControllerProxy {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    private static Logger LOGGER = LoggerFactory.getLogger(ProductControllerProxy.class);


    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto product, @RequestHeader(required = false) String requestId){
        LOGGER.info("Processing createProduct Req: {}",product);
        String url = "http://localhost:8080/product";
        String reqId = MDC.get("requestId");
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("requestId",reqId);
//        HttpEntity<ProductDto> entity = new HttpEntity(product,headers);
//        ProductDto response = restTemplate.postForObject(url,entity, ProductDto.class);

        ProductDto response = productClient.createProduct(product,reqId);
        LOGGER.info("Created Product");
        return ResponseEntity.ok(response);
    }
}
