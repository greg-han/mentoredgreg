package com.mentoredgreg.kafkaproject.solr;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.InputStreamResponseParser;
import org.springframework.stereotype.Service;

@Service
public class SolrClient {

    //@Value("${spring.kafka.solr.collection.name}")
    public static HttpSolrClient getClient(){
        String urlString = "http://localhost:8983/solr/";
        //String urlString = "http://localhost:8983/solr/" + "bookCollection";
        HttpSolrClient solr = new HttpSolrClient
                .Builder(urlString)
                .withResponseParser(new InputStreamResponseParser("application/xml"))
                .build();
        //.withResponseParser(new XMLResponseParser())
        return solr;

    }
    
}
