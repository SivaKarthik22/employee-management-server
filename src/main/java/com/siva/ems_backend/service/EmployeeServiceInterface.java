package com.siva.ems_backend.service;

import java.util.List;
import com.siva.ems_backend.dto.EmployeeDto;

public interface EmployeeServiceInterface {
    EmployeeDto createEmployee (EmployeeDto employeeDtoObj);
    EmployeeDto findEmployeeById (Long employeeId);
    List<EmployeeDto> findAllEmployees ();
    EmployeeDto updateEmployee (Long employeeId, EmployeeDto updateEmployeeDtoObj);
    void removeEmpoyee (Long emploueeId);
}
