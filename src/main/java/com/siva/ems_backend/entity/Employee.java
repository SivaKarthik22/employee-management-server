package com.siva.ems_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//annotations given by lombok:
@Getter //gives getter methods for all the properties in the following class
@Setter //gives setter methods for all the properties in the following class
@NoArgsConstructor //gives default contructor for the following class
@AllArgsConstructor //gives contructor with all arguments for the following class

//annotations for JPA:
@Entity //this annotation marks the following class as a jpa entity and creates a table for it
@Table(name = "employees") //Specifies the name of the database table that will be used to store the entity data

public class Employee {

    @Id //makes the following column as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //similar to auto-increment attribute in mySQL: generates values automatically for this column 
    private long id;

    @Column(name = "first_name", nullable = false) //Specifies the name of the column used to store the values of this field
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "department")
    private String department;

    @Column(name = "location")
    private String location;

    @Column(name = "start_date")
    private java.sql.Date startDate;

    @Column(name = "salary")
    private int salary;

    @Column(name = "phone_no", nullable = false, unique = true)
    private int phone;
}
