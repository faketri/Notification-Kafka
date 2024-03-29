package org.example.global.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfiguration {
    @Value("${TOPIC_NAME}")
    private String topic;
    @Bean
    public NewTopic newTopic(){
        return new NewTopic(topic, 1, (short) 1);
    }
}
