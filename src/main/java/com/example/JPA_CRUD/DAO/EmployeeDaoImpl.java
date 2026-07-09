package com.example.JPA_CRUD.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.example.JPA_CRUD.Entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private EntityManager entityManager;

    @Autowired
     public EmployeeDaoImpl(EntityManager entityManager){
       this.entityManager=entityManager;
     }

    @Transactional
    public void save(Employee theEmployee){
      entityManager.persist(theEmployee);
    }

    public Employee findById(int id){
       return entityManager.find(Employee.class, id);
    }
}
