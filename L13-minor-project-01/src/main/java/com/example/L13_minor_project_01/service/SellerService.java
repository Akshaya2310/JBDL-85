package com.example.L13_minor_project_01.service;

import com.example.L13_minor_project_01.dto.CreateResponseDTO;
import com.example.L13_minor_project_01.dto.ProductDTO;
import com.example.L13_minor_project_01.entity.Category;
import com.example.L13_minor_project_01.entity.Company;
import com.example.L13_minor_project_01.entity.Product;
import com.example.L13_minor_project_01.repo.CategoryRepo;
import com.example.L13_minor_project_01.repo.CompanyRepo;
import com.example.L13_minor_project_01.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {


    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private CategoryRepo categoryRepo;


    public CreateResponseDTO createProduct(ProductDTO productDTO){
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        product.setDescription(productDTO.getDescription());
        product.setActive(productDTO.getActive());
        product.setImageUrl(product.getImageUrl());

        Company company = companyRepo.findById(productDTO.getCompanyId()).get();
        product.setCompany(company);

        Category category = categoryRepo.findById(productDTO.getCategoryId()).get();
        product.setCategory(category);
        product = productRepo.save(product);
        CreateResponseDTO createResponseDTO = new CreateResponseDTO();
        createResponseDTO.setMessage("Product created successfully");
        createResponseDTO.setId(product.getId());
        return createResponseDTO;
    }
}
