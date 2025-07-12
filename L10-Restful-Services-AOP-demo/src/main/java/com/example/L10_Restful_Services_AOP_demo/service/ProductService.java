package com.example.L10_Restful_Services_AOP_demo.service;

import com.example.L10_Restful_Services_AOP_demo.dao.ProductDao;
import com.example.L10_Restful_Services_AOP_demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDAO;


    public Product getById(Long id){
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
