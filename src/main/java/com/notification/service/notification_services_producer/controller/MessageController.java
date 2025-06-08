package com.notification.service.notification_services_producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message-sending")
public class MessageController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/{message}")
    public String publishMessage(@PathVariable("message") String message) {
        kafkaTemplate.send("notification-topic", message);
        return "Publish Message:: " + message;
    }
}
