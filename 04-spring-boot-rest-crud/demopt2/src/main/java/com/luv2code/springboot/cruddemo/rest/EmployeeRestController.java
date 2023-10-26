package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee e = employeeService.findById(id);
        if(e == null) {
            throw new RuntimeException("Employee not found with id " + id);
        }
        return e;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee emp) {
        emp.setId(0);
        Employee dbEmployee = employeeService.save(emp);
        return dbEmployee;
        
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee emp) {
        Employee dbEmployee = employeeService.save(emp);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteById(@PathVariable int id) {
        Employee tempEmployee = employeeService.findById(id);
        if (tempEmployee == null) {
            throw new RuntimeException("Employee not found with id " + id);
        }
        employeeService.deleteById(id);
        return "Deleted employee with id " + id;
    }
}
