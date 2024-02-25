package com.mentoredgreg.kafkaproject.kafka;

import com.mentoredgreg.kafkaproject.solr.SolrClient;
import com.mentoredgreg.kafkaproject.solr.SolrCollection;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import com.mentoredgreg.kafkaproject.solr.SolrIndex;

import java.io.IOException;

//This is a listener that is always on.
//Whatever you put in this method will execute whenever
//a new message comes in. Ideally, this will be where you integrate Solr
//or where a Solr calling service will be called.
@Component
public class KafkaConsumer{
    SolrIndex solrIndex;
    SolrCollection solrCollection;
    @Autowired

    public KafkaConsumer(SolrIndex solrIndex, SolrCollection solrCollection){
        this.solrIndex = solrIndex;
        this.solrCollection = solrCollection;
    }
    @KafkaListener(topics = {"firstTopic"}, groupId = "testGroup")
    public void consume(String quote) throws SolrServerException, IOException {
        System.out.println("received: " + quote);
        try {
            //This will be replaced with a conditional that checks if the collection exists.
            //solrCollection.createNewCollection("bookCollection");

            //This might be put into a POJO before being sent solrIndex.updateXML()
            solrIndex.updateXML(quote);
            System.out.println("I'm done");

        } catch (SolrServerException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
