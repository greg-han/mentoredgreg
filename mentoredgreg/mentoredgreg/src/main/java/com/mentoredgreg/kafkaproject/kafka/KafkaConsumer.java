package com.mentoredgreg.kafkaproject.kafka;

import com.mentoredgreg.kafkaproject.solr.SolrIndex;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class KafkaConsumer{
    private final SolrIndex solrIndex;
    @Autowired
    public KafkaConsumer(SolrIndex solrIndex){
        this.solrIndex = solrIndex;
    }
    @KafkaListener(topics = {"musicTopic"}, groupId = "musicGroup")
    public void consume(String song) throws SolrServerException, IOException {
        solrIndex.indexJSON(song);
        //solrIndex.querySolr();
        System.out.println(song);
    }
}
