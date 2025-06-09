package com.example.backend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ElementCollection
    private List<String> availableShifts;

    private String role;
    private int maxShiftsPerWeek;

    public employee() {}

    public employee(String name, List<String> availableShifts) {
        this.name = name;
        this.availableShifts = availableShifts;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public List<String> getAvailableShifts() { return availableShifts; }
    public String getRole() { return role; }
    public int getMaxShiftsPerWeek() { return maxShiftsPerWeek; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAvailableShifts(List<String> availableShifts) { this.availableShifts = availableShifts; }
    public void setRole(String role) { this.role = role; }
    public void setMaxShiftsPerWeek(int maxShiftsPerWeek) { this.maxShiftsPerWeek = maxShiftsPerWeek; }
}