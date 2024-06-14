package com.mentoredgreg.kafkaproject.solr;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.client.solrj.request.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class SolrIndex {
    private final SolrClient solrClient;
    @Autowired
    public SolrIndex(SolrClient solrClient) {
        this.solrClient = solrClient;
    }
    public void uploadCSV(String fileLocation) throws SolrServerException, IOException {
        HttpSolrClient client = solrClient.getClient();
        UpdateRequest updateReq = new UpdateRequest();
        SolrInputDocument inputDoc = new SolrInputDocument();
        updateReq.add(inputDoc);
    }


}
