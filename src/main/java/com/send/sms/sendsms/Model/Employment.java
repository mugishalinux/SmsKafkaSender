package com.send.sms.sendsms.Model;

import lombok.*;

public class Employment {
    private int id;
    private Employment employment;
    private Company company;

    public Employment(int id, Employment employment, Company company) {
        this.id = id;
        this.employment = employment;
        this.company = company;
    }

    public Employment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employment getEmployment() {
        return employment;
    }

    public void setEmployment(Employment employment) {
        this.employment = employment;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
