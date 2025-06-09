package com.example.backend.controller;

import com.example.backend.model.employee;
import com.example.backend.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public employee addEmployee(@RequestBody employee employee) {
        return employeeService.addEmployee(employee);
    }
}
