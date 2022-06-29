package com.send.sms.sendsms.Model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

public class Company {
    private long id;
    private Long tinNumber;
    private String companyName;
    private String companyCategory;
    private LocalDate createdDate = LocalDate.now();
    private List<Employee> employees;

    public Company(long id, Long tinNumber, String companyName, String companyCategory, LocalDate createdDate, List<Employee> employees) {

        this.id = id;
        this.tinNumber = tinNumber;
        this.companyName = companyName;
        this.companyCategory = companyCategory;
        this.createdDate = createdDate;
        this.employees = employees;
    }

    public Company() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(Long tinNumber) {
        this.tinNumber = tinNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyCategory() {
        return companyCategory;
    }

    public void setCompanyCategory(String companyCategory) {
        this.companyCategory = companyCategory;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
