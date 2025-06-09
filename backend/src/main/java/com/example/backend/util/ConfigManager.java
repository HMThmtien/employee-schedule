package com.example.backend.util;

public class ConfigManager {
    private static ConfigManager instance;
    private int maxShiftsPerDay = 2;
    private int maxShiftsPerWeek = 5;

    private ConfigManager() {}

    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public int getMaxShiftsPerDay() {
        return maxShiftsPerDay;
    }
    public int getMaxShiftsPerWeek() {
        return maxShiftsPerWeek;
    }
}
