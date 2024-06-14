package com.mentoredgreg.kafkaproject.controllers;

import com.mentoredgreg.kafkaproject.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class producerController {

    @Autowired
    private KafkaProducer kafkaProducer;

    public KafkaProducer MessageController(KafkaProducer kafkaProducer){
        this.kafkaProducer = kafkaProducer;
        return this.kafkaProducer;
    }

    @GetMapping("/produce")
    public ResponseEntity<String> publish (@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("We are kafka-ing");
    }
}