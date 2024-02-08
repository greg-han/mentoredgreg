package com.mentoredgreg.kafkaproject.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

//This is a listener that is always on.
//Whatever you put in this method will execute whenever
//a new message comes in. Ideally, this will be where you integrate Solr
//or where a Solr calling service will be called.
@Component
public class KafkaConsumer{
/*
    @KafkaListener(topics = {"default"}, groupId = "testGroup")
    public void consume(String quote){
        System.out.println("received: " + quote);
    }
*/
}
