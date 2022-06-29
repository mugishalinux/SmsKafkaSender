package com.send.sms.sendsms.smsAuthRepository;

import com.send.sms.sendsms.Model.SmsAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface SmsAuthRepository extends JpaRepository<SmsAuthentication, Integer> {

}
