package com.mentoredgreg.kafkaproject.solr;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.util.ContentStreamBase.StringStream;
import org.apache.solr.client.solrj.request.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;


//A collection of solr Indexers based on type
@Repository
public class SolrIndex {

    private final SolrClient solrClient;

    @Autowired
    public SolrIndex(SolrClient solrClient) {
        this.solrClient = solrClient;
    }

    public  void updateXML(String xmlString) throws SolrServerException, IOException {
        HttpSolrClient client = solrClient.getClient();
        UpdateRequest updateReq = new UpdateRequest();
        SolrInputDocument inputDoc = new SolrInputDocument();
        StringStream stringStream = new StringStream(xmlString, "xml");
       // stringStream.setContentType("application/xml");

        inputDoc.addField("xml",stringStream);

        updateReq.add(inputDoc);
        updateReq.commit(client,"bookCollection");
    }


}
