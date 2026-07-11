package com.example.JPA_CRUD.DAO;

import java.util.List;

import com.example.JPA_CRUD.Entity.Employee;

public interface EmployeeDao {
    
    void save(Employee employee);

    Employee findById(int id);

    List<Employee> readAllEmployee();

    List<Employee> findByPara(String department);

    void updateEmployee(Employee employee);

    int deleteEmployee(int id);
}
