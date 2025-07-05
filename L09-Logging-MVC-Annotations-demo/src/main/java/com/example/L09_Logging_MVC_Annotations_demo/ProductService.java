package com.example.L09_Logging_MVC_Annotations_demo;


import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private static Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    private List<Product> products = new ArrayList<>();

    @PostConstruct
    public void  init(){
        products.add(new Product(1l,"P1"));
        products.add(new Product(2l,"P2"));
        products.add(new Product(3l,"P3"));
    }


    public String createProduct( Product product){
        LOGGER.info("Creating Product: {} ",product);
        if(product.getName()==null){
            LOGGER.error("Product Name is null, can not create it");
            return "Product Name is null";
        }
        products.add(product);
        return "Product Added";
    }

    public List<Product> getAll(){
        LOGGER.info("Fetch all Products");
        return products;
    }

    public Product getByID(Long id){
        return products.stream().filter(p->p.getId() == id).findFirst().orElse(null);
    }


}
