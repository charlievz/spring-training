package com.luv2code.cruddemo.dao;

import java.util.List;

import com.luv2code.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findByID(Integer id);

    List<Student> findAllStudents();

    List<Student> findByFirstName(String theFirstName);

    void update(Student student);

    void delete(Integer id);

    int deleteAll();
    
}