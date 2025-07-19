package com.example.L12_Spring_JDBC_demo.service;


import com.example.L12_Spring_JDBC_demo.dao.ProductDao;
import com.example.L12_Spring_JDBC_demo.dao.ProductSpringJDBCDao;
import com.example.L12_Spring_JDBC_demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

//    @Autowired
//    private ProductDao productDAO;

    @Autowired
    private ProductSpringJDBCDao productDAO;

    public Product getById(Long id){
        // Log start time of productService.getById
        return productDAO.getById(id);
    }


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
