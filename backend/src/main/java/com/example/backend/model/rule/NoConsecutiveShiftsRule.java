package com.example.backend.model.rule;

import com.example.backend.model.employee;
import com.example.backend.model.shift;
import com.example.backend.model.Schedule;
import java.util.List;

public class NoConsecutiveShiftsRule implements RuleEngine {
    @Override
    public boolean isValid(employee emp, shift s, List<Schedule> currentSchedules) {
        // Giả sử shift có trường startTime dạng "HH:mm" và day dạng "yyyy-MM-dd"
        // Kiểm tra nếu nhân viên đã có ca liền kề trước hoặc sau ca này
        // (Đơn giản hóa, thực tế nên parse LocalDateTime)
        return currentSchedules.stream().noneMatch(sc ->
            sc.getEmployee().getId().equals(emp.getId()) &&
            sc.getShift().getDay().equals(s.getDay()) &&
            (Math.abs(Integer.parseInt(sc.getShift().getStartTime().replace(":", "")) - Integer.parseInt(s.getStartTime().replace(":", ""))) <= 100)
        );
    }
    @Override
    public String getRuleName() {
        return "NoConsecutiveShiftsRule";
    }
}
