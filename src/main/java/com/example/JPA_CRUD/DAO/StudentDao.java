package com.example.JPA_CRUD.DAO;
import java.util.List;

import com.example.JPA_CRUD.Entity.Student;

public interface StudentDao {

void save(Student student);

Student findById(int id);

List<Student> findAll(); 

List<Student> findByLastName(String theLastName);

void updateStudent(Student student);

void delete(Integer id);

int deleteAll();
} 