package com.siva.ems_backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.siva.ems_backend.dto.EmployeeDto;
import com.siva.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController //indicates that the following class will handle REST API requesta
@RequestMapping("/api/employees") //creates a base url for all the methods within the controller class
public class EmployeeController {
    
    private EmployeeService employeeServiceObj;

    @PostMapping //indicates that the following method will handle incoming HTTP POST request
    public ResponseEntity<EmployeeDto> postEmployee (@RequestBody EmployeeDto employeeDtoObj){ //RequestBody maps the incoming request body to the annotated parameter of the method
        EmployeeDto savedEmployeeDtoObj = employeeServiceObj.createEmployee(employeeDtoObj);
        return new ResponseEntity<>(savedEmployeeDtoObj, HttpStatus.CREATED); //ResponseEntity is the class that represent a HTTP response
    }

    @GetMapping("{id}") //indicates that the following method will handle incoming HTTP GET request
    public ResponseEntity<EmployeeDto> getEmployeeById (@PathVariable("id") Long employeeId){ //PathVariable is used to extract a value from the URL path and bind it to the method parameter
        EmployeeDto resultEmployeeDtoObj = employeeServiceObj.findEmployeeById(employeeId);
        return new ResponseEntity<>(resultEmployeeDtoObj, HttpStatus.OK);
    }
}
