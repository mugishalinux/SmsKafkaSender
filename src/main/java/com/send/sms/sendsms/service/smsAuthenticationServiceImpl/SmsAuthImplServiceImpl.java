package com.send.sms.sendsms.service.smsAuthenticationServiceImpl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.send.sms.sendsms.Model.AuthSms;
import com.send.sms.sendsms.Model.ResponseBodyToken;
import com.send.sms.sendsms.Model.SmsAuthentication;
import com.send.sms.sendsms.service.RedisValueCache;
import com.send.sms.sendsms.service.SmsAuthService;
import com.send.sms.sendsms.smsAuthRepository.SmsAuthRepository;
import com.send.sms.sendsms.smsAuthRepository.SmsAuthantication;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Service
public class SmsAuthImplServiceImpl implements SmsAuthService {

    @Autowired
    public RestTemplate restTemplate;

    @Autowired
    public SmsAuthRepository authRepository;

    @Autowired
    public SmsAuthantication smsAuthantication;

    @Autowired
    private final RedisValueCache valueCache;

    public SmsAuthImplServiceImpl(RestTemplate restTemplate, SmsAuthRepository authRepository, SmsAuthantication smsAuthantication, final RedisValueCache valueCache) {
        this.restTemplate = restTemplate;
        this.authRepository = authRepository;
        this.smsAuthantication = smsAuthantication;
        this.valueCache = valueCache;
    }

    @Override
    public AuthSms authentication() {


      //check user
      List <SmsAuthentication > smsAuthenticationExit =  authRepository.findAll();
      SmsAuthentication tmp = new SmsAuthentication();
        for (SmsAuthentication temp : smsAuthenticationExit) {
            tmp.setUserName(temp.getUserName());
            tmp.setPassword(temp.getPassword());
        }
        Map<String, Object> loginPayload = new HashMap<>();

        loginPayload.put("api_username",tmp.getUserName());
        loginPayload.put("api_password",tmp.getPassword());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(loginPayload, headers);
        ResponseEntity<String> response = restTemplate.postForEntity("https://api.businessportal.rw/sms/api/auth/", entity, String.class);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        // login and get new token
        smsAuthantication.deleteAll();
        Gson gson = new Gson();
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson json = builder.create();
        ResponseBodyToken res = json.fromJson(response.getBody(), ResponseBodyToken.class);
        AuthSms authSms = new AuthSms();
        authSms.setRefresh_token(res.getData().getRefresh_token());
        authSms.setToken(res.getData().getAccess_token());

        AuthSms cacheObj =  smsAuthantication.save(authSms);
        valueCache.cache("#tokenId", cacheObj);
        return cacheObj;
    }

//    @CachePut(value="authSms", key="#id" , condition="#id!=null")
    @EventListener(ApplicationReadyEvent.class)
    @Scheduled(fixedRate = 10800000L)
    @Override
    public AuthSms refreshToken(){
        List <SmsAuthentication > smsAuthenticationExit =  authRepository.findAll();
        SmsAuthentication tmp = new SmsAuthentication();
        for (SmsAuthentication temp : smsAuthenticationExit) {
            tmp.setUserName(temp.getUserName());
            tmp.setPassword(temp.getPassword());
        }
        Map<String, Object> loginPayload = new HashMap<>();

        loginPayload.put("api_username",tmp.getUserName());
        loginPayload.put("api_password",tmp.getPassword());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(loginPayload, headers);
        ResponseEntity<String> response = restTemplate.postForEntity("https://api.businessportal.rw/sms/api/auth/", entity, String.class);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        System.out.println("message sent to the recipient");
        // login and get new token

        List <AuthSms> tokenObj = smsAuthantication.findAll();
        AuthSms tempToken = new AuthSms();
        for(AuthSms tmpObj : tokenObj){
            tempToken.setId(tmpObj.getId());
            tempToken.setToken(tmpObj.getToken());
            tempToken.setRefresh_token(tmpObj.getRefresh_token());
        }

        Gson gson = new Gson();
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson json = builder.create();
        ResponseBodyToken res = json.fromJson(response.getBody(), ResponseBodyToken.class);
        AuthSms authSms = new AuthSms();
        authSms.setRefresh_token(res.getData().getRefresh_token());
        authSms.setToken(res.getData().getAccess_token());
        AuthSms resetToken = new AuthSms();
        resetToken.setId(tempToken.getId());
        resetToken.setToken(authSms.getToken());
        resetToken.setRefresh_token(authSms.getRefresh_token());
        AuthSms cacheObj =  smsAuthantication.save(authSms);
        valueCache.deleteCachedValue("#tokenId");
        valueCache.cache("#tokenId" , cacheObj);
        return cacheObj;
    }

//    @Cacheable(value="senderToken" , key="#id")
    @Override
    public AuthSms getToken() {
        List <AuthSms> tokenObj = smsAuthantication.findAll();
        AuthSms senderToken = new AuthSms();
        for(AuthSms tmp : tokenObj){
            senderToken.setToken(tmp.getToken());
            senderToken.setRefresh_token(tmp.getRefresh_token());
        }
        return senderToken;
    }
}
@Configuration
@EnableScheduling
@ConditionalOnProperty(name="scheduling.enabled", matchIfMissing = true)
class SchedulingConfiguration{

}
