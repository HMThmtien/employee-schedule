package com.example.backend.model.rule;

import com.example.backend.model.employee;
import com.example.backend.model.shift;
import com.example.backend.model.Schedule;
import java.util.List;

public class MaxShiftsPerWeekRule implements RuleEngine {
    @Override
    public boolean isValid(employee emp, shift s, List<Schedule> currentSchedules) {
        long count = currentSchedules.stream()
            .filter(sc -> sc.getEmployee().getId().equals(emp.getId()))
            .count();
        return count < emp.getMaxShiftsPerWeek();
    }
    @Override
    public String getRuleName() {
        return "MaxShiftsPerWeekRule";
    }
}
