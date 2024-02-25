package com.mentoredgreg.kafkaproject.solr;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.util.ContentStreamBase.StringStream;
import org.apache.solr.client.solrj.request.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;


//A collection of solr Indexers based on type
@Repository
public class SolrIndex {

    private final SolrClient solrClient;

    @Autowired
    public SolrIndex(SolrClient solrClient) {
        this.solrClient = solrClient;
    }

    //I believe that the errors are contained within this function.
    //The collection does get created, but documents are not being uploaded to it.
    //I'm also confused about the type of stream, if any, that needs to be created before adding.
    public void updateXML(String xmlString) throws SolrServerException, IOException {
        HttpSolrClient client = solrClient.getClient();
        UpdateRequest updateReq = new UpdateRequest();
        SolrInputDocument inputDoc = new SolrInputDocument();
        StringStream stringStream = new StringStream(xmlString, "XML");
        //stringStream.setContentType("application/xml");
        System.out.println("I'm at least in here.");
        inputDoc.addField("id","bookID");
        inputDoc.addField("book",xmlString);

        updateReq.add(inputDoc);
        updateReq.commit(client,"bookCollection");
    }


}
