package com.example.backend.controller;

import com.example.backend.model.employee;
import com.example.backend.model.shift;
import com.example.backend.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    private SchedulingService schedulingService;

    @PostMapping("/assign")
    public List<shift> assignSchedule(@RequestBody ScheduleRequest request) {
        return schedulingService.assignShifts(request.getEmployees(), request.getShifts());
    }

    public static class ScheduleRequest {
        private List<employee> employees;
        private List<shift> shifts;

        public List<employee> getEmployees() { return employees; }
        public void setEmployees(List<employee> employees) { this.employees = employees; }

        public List<shift> getShifts() { return shifts; }
        public void setShifts(List<shift> shifts) { this.shifts = shifts; }
    }
}
