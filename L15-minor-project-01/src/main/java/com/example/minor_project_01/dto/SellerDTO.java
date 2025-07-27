package com.example.minor_project_01.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SellerDTO {

    private String name;
    private String email;
    private Long companyId;
}
