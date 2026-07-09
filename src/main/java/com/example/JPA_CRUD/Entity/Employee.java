package com.example.JPA_CRUD.Entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name="first_name")
    private String firstName;

    @Column(name="department")
    private String department;

     @Column(name="email")
    private String email;

    
    //constructor
    public Employee(){

    }

     public Employee(String firstName, String department, String email) {
        this.firstName = firstName;
        this.department = department;
        this.email = email;
    }

     //getter setter 
     public int getId() {
         return id;
     }

     public String getFirstName() {
         return firstName;
     }

     public String getDepartment() {
         return department;
     }

     public String getEmail() {
         return email;
     }

     public void setFirstName(String firstName) {
         this.firstName = firstName;
     }

     public void setDepartment(String department) {
         this.department = department;
     }

     public void setEmail(String email) {
         this.email = email;
     }

     @Override
     public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", department=" + department + ", email=" + email
                + "]";
     }

     
    


    
}
