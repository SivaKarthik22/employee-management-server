package com.siva.ems_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.siva.ems_backend.entity.Employee;

//JpaRepository is an interface that provides a set of methods for performing common database operations on JPA entities
//the first parameter of JpaRepository is the entity class
//the second parameter is the type of the id of the entity
//why these parameters? the methods from this interface will do operations only on the entity of the specified type. Here it is Employee entity
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    /*any method written here doesn't need function definition. 
    Spring Data JPA automatically provides implementations for these methods at runtime,
    based on the method names and parameters*/
}
