package com.siva.ems_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.siva.ems_backend.entity.Employee;
import java.util.List;

//JpaRepository is an interface that provides a predefined set of methods for performing common database operations on JPA entities
//the first parameter of JpaRepository is the entity class
//the second parameter is the type of the id of the entity
//why these parameters? the methods from this interface will do operations only on the entity of the specified type. Here it is Employee entity

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    /*any method written here doesn't need function definition. 
    Spring Data JPA automatically provides implementations for these methods at runtime,
    based on the method names and parameters*/

    @Query(value = "select * from employees e where concat(e.first_name, ' ', e.last_name) like concat('%',:name,'%') and e.location in (:location) and e.department in (:department)", nativeQuery = true)
    List<Employee> findEmployeesByFilter (@Param("name") String name, @Param("location") List<String> location, @Param("department") List<String> department);
}
