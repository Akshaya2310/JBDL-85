package com.example.L17_SpringDataRedis_demo.service;


import com.example.L17_SpringDataRedis_demo.entity.Product;
import com.example.L17_SpringDataRedis_demo.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Service
public class ProductService {


    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private RedisTemplate<String, Product> redisTemplate;

    public Product getById(Long id){
        String key = "product:"+id;
        Product product =  redisTemplate.opsForValue().get(key); //DeSerialization
        if(product == null){
            product = productRepo.findById(id).get();
            if(product != null){
                redisTemplate.opsForValue().set(key,product,10,TimeUnit.SECONDS); // Serialization
            }
        }
        return product;
    }

    public Long createProduct(Product product){
        product = productRepo.save(product);
        return product.getId();
    }
}
