package com.mentoredgreg.kafkaproject.solr;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SolrClient {
    @Bean
    public HttpSolrClient getClient(){
        String urlString = "http://localhost:8983/solr";
        HttpSolrClient solr = new HttpSolrClient
                .Builder(urlString)
                .build();
        return solr;

    }
    
}
