package com.example.L16__UTandITdemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "branch")
    private Set<Employee> employeeSet;


}
