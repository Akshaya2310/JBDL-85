package com.example.L16__UTandITdemo.service;

import com.example.L16__UTandITdemo.dao.BranchRepo;
import com.example.L16__UTandITdemo.dao.EmployeeRepo;
import com.example.L16__UTandITdemo.dto.EmployeeDetailReqDto;
import com.example.L16__UTandITdemo.entity.Address;
import com.example.L16__UTandITdemo.entity.Branch;
import com.example.L16__UTandITdemo.entity.Employee;
import com.example.L16__UTandITdemo.exception.AdhaarNotVerifiedException;
import com.example.L16__UTandITdemo.exception.LaptopAllocationFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {


    private EmployeeRepo employeeRepo;


    private BranchRepo branchRepo;

    public EmployeeService(EmployeeRepo employeeRepo, BranchRepo branchRepo) {
        this.employeeRepo = employeeRepo;
        this.branchRepo = branchRepo;
    }

    public List<Employee> getAll(){
        return employeeRepo.findAll();
    }

    public Employee findById(Long id){
        return employeeRepo.findById(id).get();
    }


    @Transactional(rollbackFor = AdhaarNotVerifiedException.class)
    public Long create(EmployeeDetailReqDto employeeDetailReq) throws AdhaarNotVerifiedException, LaptopAllocationFailedException {
        // Adhaar API call
        boolean isAdhaarVerified = true;

        // Asset Allocation API call to Asset Management System
        boolean isLaptopAllocated = true;


        Employee employee = new Employee();
        employee.setName(employeeDetailReq.getName());
        employee.setEmail(employeeDetailReq.getEmail());

        Branch branch = branchRepo.findById(employeeDetailReq.getBranchId()).get();
        employee.setBranch(branch);
        branch = branchRepo.findById(employeeDetailReq.getBranchId()).get();

        Address address = new Address();
        address.setLine1(employeeDetailReq.getLine1());
        address.setLine2(employeeDetailReq.getLine2());
        address.setCity(employeeDetailReq.getCity());
        employee.setAddress(address);

        employee = employeeRepo.save(employee);

        if(!isAdhaarVerified){
            throw new AdhaarNotVerifiedException("Adhaar verification failed");
        }
        if(!isLaptopAllocated){
            throw new LaptopAllocationFailedException("Laptop allocation failed");
        }

        return employee.getId();

    }

    public Employee findByEmail(String email){
        return employeeRepo.findByEmail(email);
    }
}
/*

1. Adhaar Verification

2. Laptop Allocation


arg = (SELECT name from Product)
Select * from Product where name=+arg+;

row=10,00,000
 */
