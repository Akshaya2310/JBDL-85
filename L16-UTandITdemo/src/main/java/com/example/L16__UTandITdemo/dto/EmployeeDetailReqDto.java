package com.example.L16__UTandITdemo.dto;


import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDetailReqDto {

    @NotNull
    private String name;
    private String email;
    private String line1;
    private String line2;
    private String city;
    private Long branchId;


}
