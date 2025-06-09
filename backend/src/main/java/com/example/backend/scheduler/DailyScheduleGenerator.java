package com.example.backend.scheduler;

import com.example.backend.model.employee;
import com.example.backend.model.shift;
import com.example.backend.model.Schedule;
import com.example.backend.repository.EmployeeRepository;
import com.example.backend.repository.ShiftRepository;
import com.example.backend.repository.ScheduleRepository;
import com.example.backend.util.SchedulingAlgorithm;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DailyScheduleGenerator {
    private final EmployeeRepository employeeRepository;
    private final ShiftRepository shiftRepository;
    private final ScheduleRepository scheduleRepository;
    private final SchedulingAlgorithm schedulingAlgorithm;

    public DailyScheduleGenerator(EmployeeRepository employeeRepository,
                                 ShiftRepository shiftRepository,
                                 ScheduleRepository scheduleRepository,
                                 SchedulingAlgorithm schedulingAlgorithm) {
        this.employeeRepository = employeeRepository;
        this.shiftRepository = shiftRepository;
        this.scheduleRepository = scheduleRepository;
        this.schedulingAlgorithm = schedulingAlgorithm;
    }

    // Chạy mỗi ngày lúc 00:00
    @Scheduled(cron = "0 0 0 * * ?")
    public void generateDailySchedule() {
        List<employee> employees = employeeRepository.findAll();
        List<shift> shifts = shiftRepository.findAll();
        List<Schedule> schedules = schedulingAlgorithm.generateSchedules(employees, shifts);
        scheduleRepository.saveAll(schedules);
    }
}
