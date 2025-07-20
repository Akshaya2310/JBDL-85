package com.example.L13_minor_project_01.controller;


import com.example.L13_minor_project_01.dto.CreateCompanyRequestDto;
import com.example.L13_minor_project_01.dto.CreateResponseDTO;
import com.example.L13_minor_project_01.dto.SellerDTO;
import com.example.L13_minor_project_01.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private static Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @PostMapping("/company")
    public ResponseEntity<CreateResponseDTO> createCompany(@RequestBody CreateCompanyRequestDto companyRequest){
        LOGGER.info("Creating company");
        return ResponseEntity.ok(adminService.createCompany(companyRequest));
    }

    @PostMapping("/seller")
    public ResponseEntity<CreateResponseDTO> createSeller(@RequestBody SellerDTO sellerDTO){
        LOGGER.info("Creating seller");
        return ResponseEntity.ok(adminService.createSeller(sellerDTO));
    }

}
