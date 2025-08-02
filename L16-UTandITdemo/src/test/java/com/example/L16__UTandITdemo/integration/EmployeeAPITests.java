package com.example.L16__UTandITdemo.integration;


import com.example.L16__UTandITdemo.dao.BranchRepo;
import com.example.L16__UTandITdemo.dao.EmployeeRepo;
import com.example.L16__UTandITdemo.dto.EmployeeDetailReqDto;
import com.example.L16__UTandITdemo.entity.Branch;
import com.example.L16__UTandITdemo.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@TestPropertySource(
        locations = ("classpath:application-it.properties")
)
public class EmployeeAPITests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BranchRepo branchRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    private EmployeeDetailReqDto employeeDetailReq1;

    private EmployeeDetailReqDto employeeDetailReq2;


    private Branch branch;


    @BeforeEach
    public void setup(){
        branch = Branch.builder()
                .name("Noida Branch")
                .build();
        branch = branchRepo.save(branch);
        employeeDetailReq1 = EmployeeDetailReqDto.builder()
                .email("ravikumar@yopmail.com")
                .name("Ravi")
                .line1("A-43")
                .line2("Sector-87")
                .city("Noida")
                .branchId(branch.getId())
                .build();


        employeeDetailReq2 = EmployeeDetailReqDto.builder()
                .email("rahul@yopmail.com")
                .line1("A-43")
                .line2("Sector-87")
                .city("Noida")
                .branchId(branch.getId())
                .build();

    }


    @Test
    public void testCreateEmpAPI() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = objectMapper.writeValueAsString(employeeDetailReq1);

        mockMvc.perform(post("/emp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonData))
                .andDo(print()).andExpect(status().isOk());

        Employee employeeFromDB = employeeRepo.findByEmail("ravikumar@yopmail.com");
        assertThat(employeeFromDB).isNotNull();
    }

    @Test
    public void testCreateEmpAPIWithoutName() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = objectMapper.writeValueAsString(employeeDetailReq2);

        mockMvc.perform(post("/emp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonData))
                .andDo(print()).andExpect(status().isBadRequest());

        Employee employeeFromDB = employeeRepo.findByEmail("rahul@yopmail.com");
        assertThat(employeeFromDB).isNull();
    }



}
