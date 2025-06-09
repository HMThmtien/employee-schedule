package com.example.backend.model.rule;

import com.example.backend.model.employee;
import com.example.backend.model.shift;
import com.example.backend.model.Schedule;
import java.util.List;

public interface RuleEngine {
    boolean isValid(employee emp, shift s, List<Schedule> currentSchedules);
    String getRuleName();
}
