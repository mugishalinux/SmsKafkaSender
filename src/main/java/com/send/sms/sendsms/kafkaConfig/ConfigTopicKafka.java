package com.send.sms.sendsms.kafkaConfig;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class ConfigTopicKafka {
    @Bean
    public NewTopic testConfigTopic(){
        return TopicBuilder.name("employmentTopicJson").build();
    }
}
