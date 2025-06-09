package com.example.backend.service;

import com.example.backend.model.employee;
import com.example.backend.model.shift;
import com.example.backend.repository.EmployeeRepository;
import com.example.backend.repository.ShiftRepository;
import com.example.backend.model.rule.RuleEngine;
import com.example.backend.model.rule.MaxShiftsPerWeekRule;
import com.example.backend.model.rule.NoConsecutiveShiftsRule;
import com.example.backend.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SchedulingService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ShiftRepository shiftRepository;
    private List<RuleEngine> rules = new ArrayList<>();
    public SchedulingService() {
        rules.add(new MaxShiftsPerWeekRule());
        rules.add(new NoConsecutiveShiftsRule());
    }
    public boolean checkAllRules(employee emp, shift s, List<Schedule> currentSchedules) {
        for (RuleEngine rule : rules) {
            if (!rule.isValid(emp, s, currentSchedules)) {
                return false;
            }
        }
        return true;
    }
    public List<shift> assignShifts(List<employee> employees, List<shift> shifts) {
        for (shift shift : shifts) {
            for (employee emp : employees) {
                if (emp.getAvailableShifts().contains(shift.getTimeSlot()) && shift.getAssignedEmployeeId() == null) {
                    shift.setAssignedEmployeeId(emp.getId());
                    break;
                }
            }
        }
        shiftRepository.saveAll(shifts);
        employeeRepository.saveAll(employees);
        return shifts;
    }
}