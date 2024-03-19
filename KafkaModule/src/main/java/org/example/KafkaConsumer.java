package org.example;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Bean
    public NewTopic topic() {
        return new NewTopic("message", 1, (short) 1);
    }

    @KafkaListener(topics = "message", groupId = "test")
    public void listen(String message){
        System.out.println(message);
    }
}
