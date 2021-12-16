package com.rutkoski.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "producer")
public class ProducerController {
    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;
    @Value(value = "${topics.test}")
    private String topicName;

    @PostMapping(value = "/send")
    public ResponseEntity<String> sendMessage(@RequestBody Message message) {
        if (message == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Message object is not set");
        }
        kafkaTemplate.send(topicName, message);
        return ResponseEntity.ok("Message Sent!");
    }
}
