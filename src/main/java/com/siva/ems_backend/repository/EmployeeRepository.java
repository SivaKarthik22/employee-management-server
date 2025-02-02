package com.siva.ems_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.siva.ems_backend.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //JpaRepository is an interface that provides a set of methods for performing common database operations on JPA entities
    //the first parameter of JpaRepository is the entity class
    //the second parameter is the type of the id of the entity
}
