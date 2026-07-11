package com.example.JPA_CRUD.DAO;

import java.util.List;

import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.example.JPA_CRUD.Entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

  private EntityManager entityManager;

  @Autowired
  public EmployeeDaoImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Transactional
  public void save(Employee theEmployee) {
    entityManager.persist(theEmployee);
  }

  public Employee findById(int id) {
    return entityManager.find(Employee.class, id);

  }

  public List<Employee> readAllEmployee() {
    TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
    return query.getResultList();
  }

  public List<Employee> findByPara(String department) {
    TypedQuery<Employee> query = entityManager.createQuery("FROM Employee WHERE department=:thedata", Employee.class);
    query.setParameter("thedata", department);
    return query.getResultList();
  }

  @Transactional
  public void updateEmployee(Employee employee){
     entityManager.merge(employee);
  }

  @Transactional
  public int deleteEmployee(int id){
    Query query=entityManager.createQuery("DELETE FROM Employee WHERE id=:id");
    query.setParameter("id", id);
    return query.executeUpdate();
  }
}
