package com.siva.ems_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String jobTitle;
    private String department;
    private String location;
    private String startDate;
    private int salary;
    private int phone;
}

//dto class just has getters and setters, it doesn't have any business logic
//this dto class object is just used as a light-weight medium to transfer data between client and server i.e. b/w service layer and repository layer
