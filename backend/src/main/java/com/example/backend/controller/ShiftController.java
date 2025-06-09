package com.example.backend.controller;

import com.example.backend.model.shift;
import com.example.backend.service.ShiftService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shifts")
public class ShiftController {
    private final ShiftService shiftService;

    public ShiftController(ShiftService shiftService) {
        this.shiftService = shiftService;
    }

    @GetMapping
    public List<shift> getAllShifts() {
        return shiftService.getAllShifts();
    }

    @PostMapping
    public shift addShift(@RequestBody shift shift) {
        return shiftService.addShift(shift);
    }
}
