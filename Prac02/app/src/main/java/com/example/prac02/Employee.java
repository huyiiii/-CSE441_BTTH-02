package com.example.prac02;

import java.util.Date;

public class Employee {
    private String id;
    private String name;
    private String dateOfBirth;
    private double salary;

    public Employee(String id, String name, String dateOfBirth, double salary) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public double getSalary() {
        return salary;
    }

    // Phương thức kiểm tra thông tin nhân viên có đầy đủ không
    public boolean isComplete() {
        return id != null && !id.isEmpty() &&
                name != null && !name.isEmpty() &&
                dateOfBirth != null && !dateOfBirth.isEmpty() &&
                salary > 0;
    }
}
