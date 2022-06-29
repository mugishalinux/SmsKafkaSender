package com.send.sms.sendsms;

import com.send.sms.sendsms.service.SmsAuthService;
import com.send.sms.sendsms.service.smsAuthenticationServiceImpl.SmsAuthImplServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import redis.clients.jedis.Jedis;
@EnableCaching
@SpringBootApplication
public class SendsmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendsmsApplication.class, args);
//		SmsAuthImplServiceImpl smsInit = new SmsAuthImplServiceImpl();
//		smsInit.authentication();
		//Connecting to Redis server on localhost
//		Jedis jedis = new Jedis("localhost");
//		System.out.println("Connection to server sucessfully");
//		//check whether server is running or not
//		System.out.println("Server is running: "+jedis.ping());
	}
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
