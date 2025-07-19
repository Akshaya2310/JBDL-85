package com.example.L12_Spring_Data_JPA_demo.controller;

import com.example.L12_Spring_Data_JPA_demo.dto.EmployeeDetailReqDto;
import com.example.L12_Spring_Data_JPA_demo.entity.Employee;
import com.example.L12_Spring_Data_JPA_demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAllEmp(){
        List<Employee> employees = employeeService.getAll();
        return employees;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id){
        Employee employee = employeeService.findById(id);
        return ResponseEntity.ok(employee);
    }


    @GetMapping("/byEmail")
    public ResponseEntity<Employee> getByEmail(@RequestParam String email){
        Employee employee = employeeService.findByEmail(email);
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<Long> createEmp(@RequestBody EmployeeDetailReqDto employeeDetailReq){
        Long id = employeeService.create(employeeDetailReq);
        return ResponseEntity.ok(id);
    }



}
