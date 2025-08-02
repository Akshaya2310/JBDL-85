package com.example.L16__UTandITdemo.repo;


import com.example.L16__UTandITdemo.dao.BranchRepo;
import com.example.L16__UTandITdemo.dao.EmployeeRepo;
import com.example.L16__UTandITdemo.dto.EmployeeDetailReqDto;
import com.example.L16__UTandITdemo.entity.Address;
import com.example.L16__UTandITdemo.entity.Branch;
import com.example.L16__UTandITdemo.entity.Employee;
import com.example.L16__UTandITdemo.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest(
        properties = {
                "spring.datasource.url=jdbc:h2:mem:testdb",
                "spring.jpa.hibernate.ddl-auto=create-drop"
        }
)
public class EmployeeRepoTest {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private BranchRepo branchRepo;

    private Employee employee;

    @BeforeEach
    public void setUp(){

        Address address = Address.builder()
                .line1("A-43")
                .line2("Sector-87")
                .city("Noida")
                .build();

        Branch branch = Branch.builder()
                .name("Noida Branch")
                .build();
        branchRepo.save(branch);

        employee = Employee.builder()
                .email("ravikumar@yopmail.com")
                .name("Ravi")
                .address(address)
                .branch(branch)
                .build();

        employee = employeeRepo.save(employee);

    }

    @Test
    public void testFindByEmail(){
        Employee employeeReturned = employeeRepo.findByEmail("ravikumar@yopmail.com");
        assertThat(employeeReturned).isEqualTo(employee);
    }


}
