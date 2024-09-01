package com.mentoredgreg.kafkaproject.solr;

import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SolrClient {
    @Bean
    public HttpSolrClient getClient(){
        String urlString = "http://127.0.0.1:8983/solr";
        HttpSolrClient solr = new HttpSolrClient
                .Builder(urlString)
                .build();
        return solr;

    }

    @Bean
    public CloudSolrClient getCloudClient(){
        String zKHostString = "zookeeper:22181";
        ArrayList<String> urlList = new ArrayList<String>(1);
        urlList.add("http://localhost:8983/solr");
        CloudSolrClient cloudSolr = new CloudSolrClient
                .Builder(urlList)
                //.withZkHost(zKHostString)
                .build();
        cloudSolr.setDefaultCollection("musicCollection");
        return cloudSolr;
    }
    
}
