package com.send.sms.sendsms.Model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

public class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private String departmentName;
    private LocalDate dob;
    private String email;
    private String phoneNumber;
    private String gender;
    private long salary;
    private LocalDate createdDate = LocalDate.now();
    private Company company;

    public Employee(long id, String firstName, String lastName, String departmentName, LocalDate dob, String email, String phoneNumber, String gender, long salary, LocalDate createdDate, Company company) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentName = departmentName;
        this.dob = dob;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.salary = salary;
        this.createdDate = createdDate;
        this.company = company;
    }

    public Employee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
