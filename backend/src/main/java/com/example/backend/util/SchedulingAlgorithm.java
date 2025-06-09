package com.example.backend.util;

import com.example.backend.model.employee;
import com.example.backend.model.shift;
import com.example.backend.model.Schedule;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SchedulingAlgorithm {
    // Simple greedy algorithm for demo
    public List<Schedule> generateSchedules(List<employee> employees, List<shift> shifts) {
        List<Schedule> schedules = new ArrayList<>();
        int empIndex = 0;
        for (shift s : shifts) {
            employee e = employees.get(empIndex % employees.size());
            Schedule schedule = new Schedule();
            schedule.setDay(s.getDay());
            schedule.setEmployee(e);
            schedule.setShift(s);
            schedules.add(schedule);
            empIndex++;
        }
        return schedules;
    }
}
