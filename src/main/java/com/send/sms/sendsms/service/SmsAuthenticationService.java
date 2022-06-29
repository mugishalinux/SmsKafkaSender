package com.send.sms.sendsms.service;

import com.send.sms.sendsms.Model.SmsAuthentication;

import java.util.List;

public interface SmsAuthenticationService {
    SmsAuthentication createSmsAuth(SmsAuthentication smsAuthentication);
    List <SmsAuthentication> allLogins();
    SmsAuthentication update(SmsAuthentication smsAuthentication , int id);
    void deleteSmsAuth(int id);
}
