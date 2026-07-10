package com.example.JPA_CRUD.DAO;

import java.util.List;

import com.example.JPA_CRUD.Entity.Employee;

public interface EmployeeDao {
    
    void save(Employee employee);

    Employee findById(int id);

    List<Employee> readAllEmployee();
}
