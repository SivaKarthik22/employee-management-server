package com.siva.ems_backend.service;

import java.util.List;
import com.siva.ems_backend.dto.EmployeeDto;

public interface EmployeeServiceInterface {
    EmployeeDto createEmployee (EmployeeDto employeeDtoObj);
    EmployeeDto findEmployeeById (Long employeeId);
    List<EmployeeDto> findAllEmployees ();
    List<EmployeeDto> findEmployeeByFilter (String name, List<String> location, List<String> department);
    EmployeeDto updateEmployee (Long employeeId, EmployeeDto updateEmployeeDtoObj);
    void removeEmpoyee (Long emploueeId);
}
