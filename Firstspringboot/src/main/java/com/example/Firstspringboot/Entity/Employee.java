package com.example.Firstspringboot.Entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_sequence")
    @SequenceGenerator(name="emp_sequence")
    long id;
    String name;
    String designation;
    double salary;
    String exe;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    Date date;

    public Employee() {
    }

    public Employee(String name, String designation, double salary, Date date) {
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.exe= exe;
        this.date= date;
    }
    public long getId() {
        return id;
    }

    public String getExe() {return exe;}

    public void setExe(String exe) {
        this.exe = exe;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}


