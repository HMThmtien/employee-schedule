package com.example.backend.service;

import com.example.backend.model.employee;
import com.example.backend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public employee addEmployee(employee employee) {
        return employeeRepository.save(employee);
    }
}
