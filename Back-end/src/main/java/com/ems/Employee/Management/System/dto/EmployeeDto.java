package com.ems.Employee.Management.System.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// pass the data through client and the server
public class EmployeeDto {
    private Long id;
    private String first_name; // json column names should be same as this
    private String last_name;
    private String email;
}
