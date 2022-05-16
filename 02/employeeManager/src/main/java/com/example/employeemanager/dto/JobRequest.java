package com.example.employeemanager.dto;

import com.example.employeemanager.model.Location;

public record JobRequest(String title, String description, Location location, int min_salary, int max_salary,
                         String email) {
}
