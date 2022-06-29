package com.send.sms.sendsms.kafkaService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.send.sms.sendsms.Model.*;
import com.send.sms.sendsms.service.RedisValueCache;
import com.send.sms.sendsms.service.SmsAuthService;
import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;
import de.danielbechler.diff.node.Visit;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

@Service
public class KafkaConsumer {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private SmsAuthService smsAuthService;

    @Autowired
    private final RedisValueCache valueCache;

    public KafkaConsumer(RestTemplate restTemplate, SmsAuthService smsAuthService, final RedisValueCache valueCache) {
        this.restTemplate = restTemplate;
        this.smsAuthService = smsAuthService;
        this.valueCache = valueCache;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = "testTopic_12", groupId ="mygroup")
    public void consumeSms(String message) throws IllegalAccessException {
        Object s = message;
        UUID randomUUID = UUID.randomUUID();
        Calendar now = Calendar.getInstance();

        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH); // Note: zero based!
        int day = now.get(Calendar.DAY_OF_MONTH);
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);
        int millis = now.get(Calendar.MILLISECOND);
        String currentTime = year+""+month+""+day+""+hour+""+minute+""+second+""+millis;
        String msgRefId = randomUUID.toString().replaceAll("_", "")+currentTime;
        String text = message;
        String myString = message;
        String[] myArray = myString.split(",");
        List<String> myList = Arrays.asList(myArray);
        Map<String, Object> smsPayload = new HashMap<>();
        smsPayload.put("msisdn", myList.get(0));
        smsPayload.put("message", myList.get(1));
        smsPayload.put("msgRef",msgRefId+"8373393");
        smsPayload.put("sender_id", myList.get(2));
        AuthSms token = (AuthSms) valueCache.getCachedValue("#tokenId");
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token.getToken());
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(smsPayload, headers);
        ResponseEntity<String> response = restTemplate.postForEntity("https://api.businessportal.rw/sms/api/mt/single", entity, String.class);
        LOGGER.info(String.format("Message Received In Demo -> %s" , message));
        LOGGER.info(String.format("Message Received In Demo -> %s" , response.getStatusCode()));
        LOGGER.info(String.format("Message Received In Demo -> %s" , response.getBody()));

//        try {
//
//            String tempObj_1 = message;
//
//            int number = tempObj_1.length();
//            String tempObj_2 = tempObj_1.substring(1,number);
//
//            StringBuffer tempObj_3 = new StringBuffer(tempObj_2);
//            tempObj_3.deleteCharAt(tempObj_3.length()-1);
//
//            System.out.println("before removed " + message);
//
//            System.out.println("removed " + tempObj_3);
//
//            JSONObject object = new JSONObject(tempObj_3);
//
//            JSONObject object_1 = new JSONObject("{\"msgRef\":\"1237099157119\",\"message\":\"Hello Dear bolly now you have been assigned to GHG LTD\",\"msisdn\":\"+250788290274\",\"sender_id\":\"Testing\"}");
//
//            JSONObject object_2 = new JSONObject(tempObj_3);
//
//            String ob = String.valueOf(object_2);
//
//            System.out.println("get element value in array " + object.getString("message"));
//        }
//        catch(Exception e) {
//            System.out.println(e);
//        }

    }


    }



//@KafkaListener(topics = "employmentTopicJson", groupId ="mygroup")
//public void consumeSms(EmploymentTopicGetter employmentTopicGetter){
////    LOGGER.info(String.format("Message Received In Demo -> %s" , message));
//    System.out.println(employmentTopicGetter.toString());
//}
