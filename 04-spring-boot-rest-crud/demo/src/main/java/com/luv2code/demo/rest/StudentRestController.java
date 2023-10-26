package com.luv2code.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.demo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    
    private List<Student> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<Student>();
        students.add(new Student("Charles", "Vinueza"));
        students.add(new Student("Juan", "Vinueza"));
        students.add(new Student("Ruth", "Vinueza"));
    }
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if (studentId >= students.size() || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return students.get(studentId);
    }
    // @ExceptionHandler
    // public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {
    //     StudentErrorResponse error = new StudentErrorResponse();
    //     error.setStatus(HttpStatus.NOT_FOUND.value());
    //     error.setMessage(ex.getMessage());
    //     error.setTimestamp(System.currentTimeMillis());
    //     return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    // }
    // // catch all
    // @ExceptionHandler
    // public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {
    //     StudentErrorResponse error = new StudentErrorResponse();
    //     error.setStatus(HttpStatus.BAD_REQUEST.value());
    //     error.setMessage(ex.getMessage());
    //     error.setTimestamp(System.currentTimeMillis());
    //     return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST); 
    // }
}