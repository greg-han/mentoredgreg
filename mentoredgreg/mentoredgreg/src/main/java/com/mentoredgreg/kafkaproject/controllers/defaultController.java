package com.mentoredgreg.kafkaproject.controllers;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class defaultController {
    @GetMapping("/")
    public void defaultMap(){
        System.out.println("Ok!");
    }

    @GetMapping("/test")
    public void test(){
        System.out.println("Thisworks");
    }
    @GetMapping("/error")
    public ResponseEntity<String> publish (){
       System.out.println("Error!");

        ResponseEntity<String> error = ResponseEntity.ok("Error");
        return  error;
    }
}
