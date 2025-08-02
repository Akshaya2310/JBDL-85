package com.example.L16__UTandITdemo.service;

import com.example.L16__UTandITdemo.dao.BranchRepo;
import com.example.L16__UTandITdemo.dao.EmployeeRepo;
import com.example.L16__UTandITdemo.dto.EmployeeDetailReqDto;
import com.example.L16__UTandITdemo.entity.Address;
import com.example.L16__UTandITdemo.entity.Branch;
import com.example.L16__UTandITdemo.entity.Employee;
import com.example.L16__UTandITdemo.exception.AdhaarNotVerifiedException;
import com.example.L16__UTandITdemo.exception.LaptopAllocationFailedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {


    private EmployeeService employeeService;

    @Mock
    private BranchRepo branchRepo;
    @Mock
    private EmployeeRepo employeeRepo;

    private EmployeeDetailReqDto employeeDetailReq;

    private Employee employee;

    private Branch branch;

    private AutoCloseable autoCloseable;


    @BeforeEach
    public void setUp(){

        autoCloseable = MockitoAnnotations.openMocks(this);
        employeeService = new EmployeeService(employeeRepo,branchRepo);

        Address address = Address.builder()
                .id(1l)
                .line1("A-43")
                .line2("Sector-87")
                .city("Noida")
                .build();

        branch = Branch.builder()
                .id(1l)
                .name("Noida Branch")
                .build();

        employee = Employee.builder()
                .email("ravikumar@yopmail.com")
                .name("Ravi")
                .address(address)
                .branch(branch)
                .id(12l)
                .build();

        employeeDetailReq = EmployeeDetailReqDto.builder()
                .email("ravikumar@yopmail.com")
                .name("Ravi")
                .line1("A-43")
                .line2("Sector-87")
                .city("Noida")
                .branchId(1l)
                .build();

    }

    @Test
    public void testCreateEmp() throws AdhaarNotVerifiedException, LaptopAllocationFailedException {
        when(employeeRepo.save(any())).thenReturn(employee);
        Optional<Branch> optionalBranch = Optional.of(branch);
        when(branchRepo.findById(1l)).thenReturn(optionalBranch);

        Long id = employeeService.create(employeeDetailReq);
        assertThat(id).isEqualTo(12);
    }

    @Test
    public void testFindByEmail(){
        when(employeeRepo.findByEmail("ravikumar@yopmail.com")).thenReturn(employee);

        Employee actualEmp = employeeService.findByEmail("ravikumar@yopmail.com");

        assertThat(actualEmp.getName()).isEqualTo(employee.getName());

    }

}
