package com.siva.ems_backend.service;

import org.springframework.stereotype.Service;
import com.siva.ems_backend.dto.EmployeeDto;
import com.siva.ems_backend.entity.Employee;
import com.siva.ems_backend.mapper.EmployeeMapper;
import com.siva.ems_backend.repository.EmployeeRepository;
import lombok.AllArgsConstructor;

@Service //marks the following class as a service provider class. It is the class that provides business functionalities
@AllArgsConstructor
public class EmployeeService implements EmployeeServiceInterface{

    private EmployeeRepository employeeRepositoryInstance;
    
    @Override
    public EmployeeDto createEmployee (EmployeeDto employeeDtoObj){
        Employee employeeObj = EmployeeMapper.mapToEmployee(employeeDtoObj);
        Employee savedEmployeeObj = employeeRepositoryInstance.save(employeeObj); //save method persists or merges an entity to the database and returns the saved entity
        return EmployeeMapper.mapToEmployeeDto(savedEmployeeObj);
    }
}
