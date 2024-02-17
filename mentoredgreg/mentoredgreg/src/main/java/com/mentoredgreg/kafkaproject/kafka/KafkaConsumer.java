package com.mentoredgreg.kafkaproject.kafka;

import com.mentoredgreg.kafkaproject.solr.solrClient;
import com.mentoredgreg.kafkaproject.solr.solrCore;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

//This is a listener that is always on.
//Whatever you put in this method will execute whenever
//a new message comes in. Ideally, this will be where you integrate Solr
//or where a Solr calling service will be called.
@Component
public class KafkaConsumer{
    @KafkaListener(topics = {"firstTopic"}, groupId = "testGroup")
    public void consume(String quote) throws SolrServerException, IOException {
        System.out.println("received: " + quote);
        try {
            solrCore.getNewCore("bookCore");

        } catch (SolrServerException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
