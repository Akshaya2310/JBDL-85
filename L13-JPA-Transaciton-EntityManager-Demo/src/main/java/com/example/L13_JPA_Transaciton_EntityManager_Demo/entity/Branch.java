package com.example.L13_JPA_Transaciton_EntityManager_Demo.entity;

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
