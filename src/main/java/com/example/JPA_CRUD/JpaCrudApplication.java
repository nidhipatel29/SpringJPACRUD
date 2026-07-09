package com.example.JPA_CRUD;
import com.example.JPA_CRUD.DAO.EmployeeDaoImpl;
import java.util.List;
import com.example.JPA_CRUD.DAO.StudentDaoImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.JPA_CRUD.DAO.StudentDao;
import com.example.JPA_CRUD.DAO.EmployeeDao;
import com.example.JPA_CRUD.Entity.Employee;
import com.example.JPA_CRUD.Entity.Student;

@SpringBootApplication
public class JpaCrudApplication {


    public static void main(String[] args) {
		SpringApplication.run(JpaCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao,EmployeeDao employeeDao){
		return runner ->{
          //createStudent(studentDao);
		  //createEmployee(employeeDao);

		 // viewStuent(studentDao);
		  //viewEmployee(employeeDao);

		  //findAllStudent(studentDao);
		  //FindStudentByLastName(studentDao);

		  //updateStudentsById(studentDao);

		  deleteStudent(studentDao);

		};
	}

    private void createStudent(StudentDao studentDao) {
		// TODO Auto-generated method stub
		Student  tempStudent=new Student("nidhi","patel","n'@'gmail.com");
		studentDao.save(tempStudent);
		System.out.println("saved student id:" + tempStudent.getId());
	}

	private void createEmployee(EmployeeDao theEmployeeDao){
        Employee tempEmployee=new Employee("Paranshu" ,"RTM","patel@gmail.com");
		theEmployeeDao.save(tempEmployee);
		System.out.println("save employee details is:" + tempEmployee.getFirstName());
	}

	private void viewStuent(StudentDao studentDao) {
		//save the student
		Student tempStuednt=new Student("rashmi","patel","rashmi@gmail.com");
		studentDao.save(tempStuednt);

		//get the student by id
		System.out.println("save stuent is:" + tempStuednt.getId());

		//retriving student
		Student myStudent=studentDao.findById(tempStuednt.getId());

		//disply student
		System.out.println("student detail is:" + myStudent);
	}

	private void viewEmployee(EmployeeDao employeeDao) {
		Employee tempEmployee = new Employee("sneha", "IT", "s@gmail.com");
		employeeDao.save(tempEmployee);

		System.out.println("saved employee id: " + tempEmployee.getId());

		Employee myEmployee = employeeDao.findById(tempEmployee.getId());
		System.out.println(myEmployee);
	}

	//retriving all students
	private void findAllStudent(StudentDao studentDao){
		//retriving students
		List<Student> theStudent=studentDao.findAll();

		//disaply students
		for(Student tempStudent:theStudent){
			System.out.println(tempStudent);
		}
		
	}

	//getting the student based on lastname query
	private void FindStudentByLastName(StudentDao studentDao){
      
		//retriving the list of student
        List<Student> tempStudents=studentDao.findByLastName("patel");
		//display the list of student
		for(Student s:tempStudents){
			System.out.println(s);
		}

	}

	//updating student......
	private void updateStudentsById(StudentDao studentDao){
     //retriving the student by id...employeeDaoImpl
      
	  int studentId=1;
	  Student student=studentDao.findById(studentId);

	 //setting the student by last name
	 student.setLastName("Obroy");

	 //updating the student
	 studentDao.updateStudent(student);


	 //display the updated student 
      System.out.println(student);

	}

	//deleting student
	private void deleteStudent(StudentDao studentDao){
     int studentId=1;
    studentDao.delete(studentId);

	}

}
