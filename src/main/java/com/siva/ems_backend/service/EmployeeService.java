package com.siva.ems_backend.service;

import org.springframework.stereotype.Service;
import com.siva.ems_backend.dto.EmployeeDto;
import com.siva.ems_backend.entity.Employee;
import com.siva.ems_backend.exception.ResourceNotFoundException;
import com.siva.ems_backend.mapper.EmployeeMapper;
import com.siva.ems_backend.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

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

    @Override
    public EmployeeDto findEmployeeById (Long employeeId){
        Optional<Employee> resultEmployeeOptionalObj = employeeRepositoryInstance.findById(employeeId);
        //findById retrieves an entity based on the given primary key and returns Optional of type Entity.
        //Optional object may or may not contain a non null value.
        Employee resultEmployeeObj = resultEmployeeOptionalObj.orElseThrow(()-> new ResourceNotFoundException("Employee with " + employeeId + " doesn't exists"));
        //orElseThrow method gets the value of the Optional if present. if not, it throws the exception given by supplier
        return EmployeeMapper.mapToEmployeeDto(resultEmployeeObj);
    }

    @Override
    public List<EmployeeDto> findAllEmployees(){
        List<Employee> resultEmployeesList = employeeRepositoryInstance.findAll(); //returns a List of all entities of a specific type that exist in the database
        List<EmployeeDto> resultEmployeeDtosList = new ArrayList<>();
        for(int i=0; i< resultEmployeesList.size(); i++){
            EmployeeDto employeeDtoObj = EmployeeMapper.mapToEmployeeDto(resultEmployeesList.get(i));
            resultEmployeeDtosList.add(employeeDtoObj);
        }
        return resultEmployeeDtosList;
    }

    @Override
    public EmployeeDto updateEmployee (Long employeeId, EmployeeDto updateEmployeeDtoObj){
        Optional<Employee> employeeOptionalObj = employeeRepositoryInstance.findById(employeeId);
        Employee employeeObj = employeeOptionalObj.orElseThrow(() -> new ResourceNotFoundException("Employee with " + employeeId + " doesn't exists"));
        
        employeeObj.setFirstName(updateEmployeeDtoObj.getFirstName());
        employeeObj.setLastName(updateEmployeeDtoObj.getLastName());
        employeeObj.setEmail(updateEmployeeDtoObj.getEmail());
        
        Employee savedEmployeeObj = employeeRepositoryInstance.save(employeeObj);
        return EmployeeMapper.mapToEmployeeDto(savedEmployeeObj);
    }

    @Override
    public void removeEmpoyee (Long employeeId){
        employeeRepositoryInstance.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee with " + employeeId + " doesn't exists"));
        employeeRepositoryInstance.deleteById(employeeId);
    }
}
