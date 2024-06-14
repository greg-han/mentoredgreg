package com.mentoredgreg.kafkaproject.kafka;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class KafkaConsumer{

    public KafkaConsumer(){
    }
    @KafkaListener(topics = {"firstTopic"}, groupId = "testGroup")
    public void consume(String quote) throws SolrServerException, IOException {
        System.out.println("I'm done");

    }
}
