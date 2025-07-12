package com.example.L10_SpringController_Annotations_Lombok_demo;


import org.example.KeywordAnalyzerInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class AppController {
    private static Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    @Autowired
    private ProductService productService;

    @Autowired(required = false)
    private KeywordAnalyzerInterface keywordAnalyzer;

//    @Autowired
//    private KeywordAnalyzerInterface keywordAnalyzer;

//    @Autowired
//    @Qualifier("uniqueKeywordAnalyzer")
//    private KeywordAnalyzerInterface keywordAnalyzer;

    @GetMapping("/hello")
    public String sayHello(@RequestParam(required = false)  String name){
        LOGGER.info("Processing request for name: {}",name);
        return "Hello "+ name+ " World :"+Thread.currentThread().getName();
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        LOGGER.info("Processing get all Products Request");
        return productService.getAll();
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable Long id){
        return productService.getByID(id);
    }

    @PostMapping("/product")
    public String addProduct(@RequestBody Product product, @RequestHeader Integer appId){
        LOGGER.info("Calling product service...");
        return productService.createProduct(product);
    }

    @GetMapping("/search/products")
    public List<Product> searchProduct(@RequestParam String keyword){
        keywordAnalyzer.recordKeyword(keyword);
        return productService.searchProduct(keyword);
    }

    @GetMapping("/allKeyword")
    public List<String> allKeywords(){
        return keywordAnalyzer.getKeywords();
    }



}
