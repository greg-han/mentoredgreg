package com.mentoredgreg.kafkaproject.solr;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.InputStreamResponseParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
public class SolrClient {
    @Bean
    public HttpSolrClient getClient(){
        //trying both of these URL's
        String urlString = "http://localhost:8983/solr/";
        //String urlString = "http://localhost:8983/solr/" + "bookCollection";
        HttpSolrClient solr = new HttpSolrClient
                .Builder(urlString)
                .withResponseParser(new InputStreamResponseParser("application/xml"))
                .build();
        //Trying different response parsers.
        //.withResponseParser(new XMLResponseParser())
        return solr;

    }
    
}
