package com.mentoredgreg.kafkaproject.kafka;

import com.mentoredgreg.kafkaproject.solr.SolrClient;
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

    private SolrIndex solrIndex;

    @Autowired
    public KafkaConsumer(SolrIndex solrIndex) {
        this.solrIndex = solrIndex;
    }
    @KafkaListener(topics = {"firstTopic"}, groupId = "testGroup")
    @Async
    public void consume(String quote) throws SolrServerException, IOException {
        System.out.println("received: " + quote);
        try {
            //solrCollection.createNewCollection("bookCollection");
            //Put this in a POJO, and then use a DB call from there.
            //I think that this particular line is causing issues.
            solrIndex.updateXML(quote);

        } catch (SolrServerException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
