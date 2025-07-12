package com.example.L10_SpringController_Annotations_Lombok_demo;

import lombok.*;


@Data
@AllArgsConstructor
public class Person {
    private Long id;
    private Integer age;
    private String name;
}
