package com.send.sms.sendsms.service;

import com.send.sms.sendsms.Model.AuthSms;
import org.springframework.stereotype.Component;


public interface SmsAuthService {
    AuthSms authentication();
    AuthSms refreshToken();
    AuthSms getToken();
}
