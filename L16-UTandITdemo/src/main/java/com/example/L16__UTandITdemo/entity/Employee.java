package com.example.L16__UTandITdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "empName", nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Address address;

    @ManyToOne
    @JsonIgnoreProperties("employeeSet")
    private Branch branch;


    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Employee employee = (Employee) object;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(email, employee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }
}