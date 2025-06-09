package com.example.backend.factory;

import com.example.backend.model.employee;

public class EmployeeFactory {
    public static employee create(Long id, String name, String role, int maxShiftsPerWeek) {
        employee emp = new employee();
        emp.setId(id);
        emp.setName(name);
        emp.setRole(role);
        emp.setMaxShiftsPerWeek(maxShiftsPerWeek);
        return emp;
    }
}
