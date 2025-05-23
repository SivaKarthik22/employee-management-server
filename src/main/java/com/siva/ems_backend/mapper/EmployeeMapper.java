package com.siva.ems_backend.mapper;

import com.siva.ems_backend.dto.EmployeeDto;
import com.siva.ems_backend.entity.Employee;

//the mapper class provide the methods to convert data from DTO object to domain object(entity) and vice versa
public class EmployeeMapper {
    public static Employee mapToEmployee (EmployeeDto employeeDtoObj){
        return new Employee(
            employeeDtoObj.getId(),
            employeeDtoObj.getFirstName(),
            employeeDtoObj.getLastName(),
            employeeDtoObj.getEmail(),
            employeeDtoObj.getJobTitle(),
            employeeDtoObj.getDepartment(),
            employeeDtoObj.getLocation(),
            employeeDtoObj.getStartDate(),
            employeeDtoObj.getSalary(),
            employeeDtoObj.getPhone()
        );
    }
    public static EmployeeDto mapToEmployeeDto (Employee employeeObj){
        return new EmployeeDto(
            employeeObj.getId(),
            employeeObj.getFirstName(),
            employeeObj.getLastName(),
            employeeObj.getEmail(),
            employeeObj.getJobTitle(),
            employeeObj.getDepartment(),
            employeeObj.getLocation(),
            employeeObj.getStartDate(),
            employeeObj.getSalary(),
            employeeObj.getPhone()
        );
    }
}
