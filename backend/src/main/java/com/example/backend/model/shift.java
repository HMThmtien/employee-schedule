package com.example.backend.model;

import jakarta.persistence.*;

@Entity
public class shift {
    @Id
    private String shiftId;

    private String timeSlot;

    private Long assignedEmployeeId;

    private String day;
    private String startTime;
    private String endTime;
    private String requiredRole;

    public shift() {}

    public shift(String shiftId, String timeSlot) {
        this.shiftId = shiftId;
        this.timeSlot = timeSlot;
    }

    public String getShiftId() { return shiftId; }
    public String getTimeSlot() { return timeSlot; }
    public Long getAssignedEmployeeId() { return assignedEmployeeId; }
    public String getDay() { return day; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
    public String getRequiredRole() { return requiredRole; }

    public void setShiftId(String shiftId) { this.shiftId = shiftId; }
    public void setTimeSlot(String timeSlot) { this.timeSlot = timeSlot; }
    public void setAssignedEmployeeId(Long assignedEmployeeId) { this.assignedEmployeeId = assignedEmployeeId; }
    public void setDay(String day) { this.day = day; }
    public void setStartTime(String startTime) { this.startTime = startTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }
    public void setRequiredRole(String requiredRole) { this.requiredRole = requiredRole; }

    
}
