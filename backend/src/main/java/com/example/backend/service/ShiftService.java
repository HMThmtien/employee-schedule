package com.example.backend.service;

import com.example.backend.model.shift;
import com.example.backend.repository.ShiftRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftService {
    private final ShiftRepository shiftRepository;

    public ShiftService(ShiftRepository shiftRepository) {
        this.shiftRepository = shiftRepository;
    }

    public List<shift> getAllShifts() {
        return shiftRepository.findAll();
    }

    public shift addShift(shift shift) {
        return shiftRepository.save(shift);
    }
}
