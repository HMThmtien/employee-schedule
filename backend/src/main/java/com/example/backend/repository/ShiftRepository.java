package com.example.backend.repository;

import com.example.backend.model.shift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftRepository extends JpaRepository<shift, String> {
}
