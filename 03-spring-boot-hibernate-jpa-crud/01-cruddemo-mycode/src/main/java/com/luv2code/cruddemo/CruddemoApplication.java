package com.luv2code.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// findAllStudents(studentDAO);
			// findByFirstName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAll(studentDAO);

		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		System.out.println("Deleted students: " + studentDAO.deleteAll());
	}

	private void findByFirstName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByFirstName("Charles");
		for(Student s : students) {
			System.out.println(s);
		}
	}



	private void findAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAllStudents();
		for(Student s : students) {
			System.out.println(s);
		}
	}

	// private void deleteStudent(StudentDAO studentDAO) {
	// 	findAllStudents(studentDAO);
	// 	// studentDAO.delete(2);
	// 	System.out.println("deleted student with id of");
	// 	findAllStudents(studentDAO);
	// }

	// private void updateStudent(StudentDAO studentDAO) {
	// 	int id = 3003;
	// 	Student myStudent = studentDAO.findByID(id);
	// 	System.out.println("Found student");
	// 	System.out.println(myStudent.toString());

	// 	System.out.println("Updating student");
	// 	myStudent.setFirstName("Michael");
	// 	studentDAO.update(myStudent);

	// 	myStudent = studentDAO.findByID(id);
	// 	System.out.println("Updated student");
	// 	System.out.println(myStudent.toString());

	// }
	

	// private void readStudent(StudentDAO studentDAO) {
	// 	Student tempStudent1 = new Student("Mike", "Vinueza", "mike@luv2code.com");
	// 	studentDAO.save(tempStudent1);
	// 	int id = tempStudent1.getId();
	// 	System.out.println("Saved student. Generated id: " + id);
		
	// 	Student myStudent = studentDAO.findByID(id);
	// 	System.out.println("Found student" + id);
	// 	System.out.println(myStudent.toString());

	// }

	private void createMultipleStudents(StudentDAO studentDAO) {
		Student tempStudent1 = new Student("Paul", "Vinueza", "paul@luv2code.com");
		Student tempStudent2 = new Student("Charles", "Vinueza", "charles@luv2code.com");
		Student tempStudent3 = new Student("John", "Vinueza", "John@luv2code.com");
		
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	// private void createStudent(StudentDAO studentDAO) {	
	// 	// create the student object
	// 	System.out.println("Creating new student object...");
	// 	Student tempStudent = new Student("Paul", "Vinueza", "paul@luv2code.com");
	// 	// save the student object
	// 	System.out.println("Saving student object...");
	// 	studentDAO.save(tempStudent);
	// 	// display id of the saved student
	// 	System.out.println("Student ID: " + tempStudent.getId());
	// }

}
