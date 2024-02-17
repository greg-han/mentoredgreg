package com.mentoredgreg.kafkaproject.solr;

import org.apache.solr.client.solrj.impl.Http2SolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class solrClient {
    @Value("${spring.kafka.solr.collection.name}")
    static String collectionName;
    @Bean
    public static Http2SolrClient getClient(){
        String urlString = "http://localhost:8983/solr/" + collectionName + "/";
        Http2SolrClient solr = new Http2SolrClient
                .Builder(urlString)
                .withResponseParser(new XMLResponseParser())
                .build();
        return solr;
    }
    
}
