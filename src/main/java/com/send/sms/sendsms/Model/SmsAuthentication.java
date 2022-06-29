package com.send.sms.sendsms.Model;

import lombok.*;
import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;



@Builder
@Entity
@ToString
@Table(name = "logins")
public class SmsAuthentication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String userName;
    private String password;

    public SmsAuthentication(int id, String userName, String password) {
        Id = id;
        this.userName = userName;
        this.password = password;
    }

    public SmsAuthentication() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmsAuthentication that = (SmsAuthentication) o;
        return Id == that.Id && Objects.equals(userName, that.userName) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, userName, password);
    }

}
