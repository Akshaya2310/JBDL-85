package com.example.L11_AOP_JDBC_Demo.service;

import com.example.L11_AOP_JDBC_Demo.aspect.LogExecutionTime;
import com.example.L11_AOP_JDBC_Demo.dao.ProductDao;
import com.example.L11_AOP_JDBC_Demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDAO;

    @LogExecutionTime
    public Product getById(Long id){
        // Log start time of productService.getById
        return productDAO.getById(id);
    }

    @LogExecutionTime
    public Product create(Product product){
        return productDAO.create(product);
    }

    public Product update(Long id, Product product){
        return productDAO.update(id,product);
    }

    public Product delete(Long id){
        return productDAO.delete(id);
    }


}
