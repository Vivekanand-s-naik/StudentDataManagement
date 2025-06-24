package com.main.controller;

public class UserController {
    // Input Validation 
    public boolean isValidId(int id) {
        return id > 0;
    }

    public boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public boolean isValidPercent(int percent) {
        return percent >= 0 && percent <= 100;
    }

    public boolean isValidCourse(String course) {
        return course != null && !course.trim().isEmpty();
    }
}
