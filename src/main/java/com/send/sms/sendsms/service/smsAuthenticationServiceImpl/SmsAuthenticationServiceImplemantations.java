package com.send.sms.sendsms.service.smsAuthenticationServiceImpl;

import com.send.sms.sendsms.Model.SmsAuthentication;
import com.send.sms.sendsms.service.SmsAuthenticationService;
import com.send.sms.sendsms.smsAuthRepository.SmsAuthRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SmsAuthenticationServiceImplemantations implements SmsAuthenticationService {

    private SmsAuthRepository smsAuthRepository;

    public SmsAuthenticationServiceImplemantations(SmsAuthRepository smsAuthRepository) {
        this.smsAuthRepository = smsAuthRepository;
    }

    @Override
    public SmsAuthentication createSmsAuth(SmsAuthentication smsAuthentication) {
        return smsAuthRepository.save(smsAuthentication);
    }

    @Override
    public List<SmsAuthentication> allLogins() {
        return smsAuthRepository.findAll();
    }

    @Override
    public SmsAuthentication update(SmsAuthentication smsAuthentication, int id) {
        SmsAuthentication existSmsAuth = smsAuthRepository.findById(id).orElseThrow();
        existSmsAuth.setUserName(smsAuthentication.getUserName());
        existSmsAuth.setPassword(smsAuthentication.getPassword());
        smsAuthRepository.save(existSmsAuth);
        return existSmsAuth;
    }

    @Override
    public void deleteSmsAuth(int id) {
       smsAuthRepository.deleteById(id);
    }
}
