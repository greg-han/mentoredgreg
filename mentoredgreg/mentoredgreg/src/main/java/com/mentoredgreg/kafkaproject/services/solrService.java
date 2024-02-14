package com.mentoredgreg.kafkaproject.services;

import org.apache.solr.client.solrj.impl.Http2SolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.impl.JsonMapResponseParser;
import org.apache.solr.client.solrj.impl.InputStreamResponseParser;
import org.springframework.beans.factory.annotation.Value;



public class solrService {
    @Value("${spring.kafka.solr.instance.name}")
    String instanceName;

    String urlString = "http://localhost:8983/solr/" + instanceName + "/";
    Http2SolrClient solr = new Http2SolrClient.Builder(urlString).withResponseParser(new XMLResponseParser()).build();
}
