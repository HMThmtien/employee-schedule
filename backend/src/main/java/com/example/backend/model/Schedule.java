package com.example.backend.model;

import jakarta.persistence.*;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String day;

    @ManyToOne
    private employee employee;

    @ManyToOne
    private shift shift;

    public Schedule() {
    }

    public Schedule(String day, employee employee, shift shift) {
        this.day = day;
        this.employee = employee;
        this.shift = shift;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public employee getEmployee() {
        return employee;
    }

    public void setEmployee(employee employee) {
        this.employee = employee;
    }

    public shift getShift() {
        return shift;
    }

    public void setShift(shift shift) {
        this.shift = shift;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
