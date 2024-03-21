package org.example.global.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.example.entity.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class KafkaProducers {

    private final String topic;
    private final KafkaTemplate<String, Users> kafkaProducer;

    public KafkaProducers(@Value("${TOPIC_NAME}") String topic, KafkaTemplate<String, Users> kafkaProducer) {
        this.topic = topic;
        this.kafkaProducer = kafkaProducer;
    }

    public void sendMessage(Set<Users> users) {
        users.forEach(user ->
                kafkaProducer.send(
                        new ProducerRecord<>(topic, user.getId().toString(), user)));
    }
}
