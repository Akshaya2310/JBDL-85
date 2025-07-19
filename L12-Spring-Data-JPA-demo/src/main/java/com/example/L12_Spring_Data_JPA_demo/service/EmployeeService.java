package com.example.L12_Spring_Data_JPA_demo.service;

import com.example.L12_Spring_Data_JPA_demo.dao.BranchRepo;
import com.example.L12_Spring_Data_JPA_demo.dao.EmployeeRepo;
import com.example.L12_Spring_Data_JPA_demo.dto.EmployeeDetailReqDto;
import com.example.L12_Spring_Data_JPA_demo.entity.Address;
import com.example.L12_Spring_Data_JPA_demo.entity.Branch;
import com.example.L12_Spring_Data_JPA_demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private BranchRepo branchRepo;

    public List<Employee> getAll(){
        return employeeRepo.findAll();
    }

    public Employee findById(Long id){
        return employeeRepo.findById(id).get();
    }


    public Long create(EmployeeDetailReqDto employeeDetailReq){

        Employee employee = new Employee();
        employee.setName(employeeDetailReq.getName());
        employee.setEmail(employeeDetailReq.getEmail());

        Branch branch = branchRepo.findById(employeeDetailReq.getBranchId()).get();
        employee.setBranch(branch);

        Address address = new Address();
        address.setLine1(employeeDetailReq.getLine1());
        address.setLine2(employeeDetailReq.getLine2());
        address.setCity(employeeDetailReq.getCity());
        employee.setAddress(address);

        employeeRepo.save(employee);
        return employee.getId();

    }

    public Employee findByEmail(String email){
        return employeeRepo.findByEmail(email);
    }
}
