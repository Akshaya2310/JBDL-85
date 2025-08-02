package com.example.L16__UTandITdemo.dao;

import com.example.L16__UTandITdemo.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepo extends JpaRepository<Branch,Long> {
}
