package com.send.sms.sendsms.Model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Builder
@Entity
@ToString
@Table(name = "Auth")
public class AuthSms implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2000)
    private String token;

    @Column(length = 2000)
    private String refresh_token;

    public AuthSms(Long id, String token, String refresh_token) {
        this.id = id;
        this.token = token;
        this.refresh_token = refresh_token;
    }

    public AuthSms() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthSms authSms = (AuthSms) o;
        return Objects.equals(id, authSms.id) && Objects.equals(token, authSms.token) && Objects.equals(refresh_token, authSms.refresh_token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, token, refresh_token);
    }

    @Override
    public String toString() {
        return "AuthSms{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
                '}';
    }
}
