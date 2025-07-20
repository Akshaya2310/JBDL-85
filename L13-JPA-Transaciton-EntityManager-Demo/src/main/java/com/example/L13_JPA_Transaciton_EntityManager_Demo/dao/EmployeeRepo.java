package com.example.L13_JPA_Transaciton_EntityManager_Demo.dao;

import com.example.L13_JPA_Transaciton_EntityManager_Demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    Employee findByEmail(String email);

    List<Employee> findByName(String name);
}
