package com.example.L13_minor_project_01.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {

    private String name;
    private String description;

    private Double price;
    private Integer stock;
    private Boolean active;

    private String imageUrl;
    private Long companyId;
    private Long categoryId;

}
