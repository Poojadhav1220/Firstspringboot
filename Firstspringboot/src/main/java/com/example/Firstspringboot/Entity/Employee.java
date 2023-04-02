package com.example.Firstspringboot.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;


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

    public Employee() {
    }

    public Employee(String name, String designation, double salary) {
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.exe= exe;
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


}


