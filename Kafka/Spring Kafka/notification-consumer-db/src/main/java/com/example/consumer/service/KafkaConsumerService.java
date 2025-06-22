package com.example.consumer.service;

import com.example.consumer.entity.Notification;
import com.example.consumer.repository.NotificationRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final NotificationRepository repository;

    public KafkaConsumerService(NotificationRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "notifications", groupId = "notification-group")
    public void listen(String message) {
        System.out.println("Received: " + message);
        repository.save(new Notification(message));
    }
}
