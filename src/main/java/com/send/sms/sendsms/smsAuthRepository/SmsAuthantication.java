package com.send.sms.sendsms.smsAuthRepository;

import com.send.sms.sendsms.Model.AuthSms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface SmsAuthantication extends JpaRepository<AuthSms,Long> {
    
}
