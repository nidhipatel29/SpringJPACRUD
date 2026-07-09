package com.example.JPA_CRUD.DAO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import com.example.JPA_CRUD.Entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDaoImpl implements StudentDao {

private EntityManager entityManager;
@Autowired
 public StudentDaoImpl(EntityManager entityManager){
    this.entityManager=entityManager;
 }

    @Transactional
   public void save(Student theStudent){
      entityManager.persist(theStudent);
    }


    //retriving student object
    public Student findById(int id){
     return entityManager.find(Student.class, id);
    }

    //retriving all students
    public List<Student> findAll(){
     
        TypedQuery<Student> query=entityManager.createQuery("FROM Student WHERE email LIKE 'n%'",Student.class);
        return query.getResultList();
    }

    //setting the parameter
    public List<Student> findByLastName(String theLastName){
    //create query
    TypedQuery<Student> query=entityManager.createQuery("FROM Student WHERE lastName=:thedata",Student.class);

    //setting the parameter
     query.setParameter("thedata", theLastName);
    //get the student list

    return query.getResultList();
    }

    //updating student
    @Transactional
    public void updateStudent(Student student){

       entityManager.merge(student);
    }

    //deleting student
    @Transactional
    public void delete(Integer id){
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
        }
    }


}
