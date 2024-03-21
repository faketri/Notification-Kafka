package org.example.event.listener;

import org.example.event.events.ProductAdditionEvent;
import org.example.global.kafka.KafkaProducers;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ProductEventListener {

    private final KafkaProducers kafkaProducer;

    public ProductEventListener(KafkaProducers kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @EventListener(ProductAdditionEvent.class)
    public void reportProductAddition(ProductAdditionEvent event){
        kafkaProducer.sendMessage(event.getUsersSubscribe());
        System.out.println(event.getUsersSubscribe());
    }
}
