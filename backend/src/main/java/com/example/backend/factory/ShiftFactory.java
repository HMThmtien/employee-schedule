package com.example.backend.factory;

import com.example.backend.model.shift;

public class ShiftFactory {
    public static shift create(String shiftId, String day, String timeSlot, String startTime, String endTime, String requiredRole) {
        shift s = new shift();
        s.setShiftId(shiftId);
        s.setDay(day);
        s.setTimeSlot(timeSlot);
        s.setStartTime(startTime);
        s.setEndTime(endTime);
        s.setRequiredRole(requiredRole);
        return s;
    }
}
