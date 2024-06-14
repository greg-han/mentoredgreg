package com.mentoredgreg.kafkaproject.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class defaultController {
    @GetMapping("/")
    public void defaultMap(){
        System.out.println("Ok!");
    }
    @GetMapping("/error")
    public ResponseEntity<String> publish (){
        System.out.println("Error!");
        ResponseEntity<String> error = ResponseEntity.ok("Error");
        return  error;
    }
}
