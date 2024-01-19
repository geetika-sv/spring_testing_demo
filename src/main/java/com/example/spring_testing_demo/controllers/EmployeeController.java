package com.example.spring_testing_demo.controllers;


import com.example.spring_testing_demo.models.Employee;
import com.example.spring_testing_demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // Get all employees
    //Get: /api/employees
    @GetMapping
    public Iterable<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }


    // Get onr employee by id
    // GET: /api/employees/{id}
    @GetMapping("/{id}")
    public Optional<Employee> getOneEmployeeById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    //Create one employee
    // POST: /api/employees
    @PostMapping
    public Employee postEmployee(@RequestBody Employee employee) {
        return service.createEmployee(employee);
    }

    //put one user
    //PUT: /api/employees/{id}
    @PostMapping("/{id}")
    public Employee putEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return service.updateEmployeeById(id, employee);
    }

    //Delete one employee
    //DELETE: /api/employees/{id}
    @DeleteMapping("/{id}")
    public boolean deleteOneById(@PathVariable Long id) {
        return service.deleteEmployeeById(id);
    }
}
