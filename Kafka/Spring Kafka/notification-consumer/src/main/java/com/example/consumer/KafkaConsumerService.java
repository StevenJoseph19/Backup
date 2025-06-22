package com.example.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "notifications", groupId = "notification-group")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
