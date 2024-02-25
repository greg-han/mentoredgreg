package com.mentoredgreg.kafkaproject.solr;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.request.CollectionAdminRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class SolrCollection {

    private SolrClient solrClient;

    @Autowired
    public SolrCollection(SolrClient solrClient){
        this.solrClient = solrClient;
    }

    public void createNewCollection(String collectionName) throws SolrServerException, IOException {
        CollectionAdminRequest.Create newCollection = CollectionAdminRequest
                .Create.createCollection("bookCollection",2,2);

        try {
            newCollection.process(solrClient.getClient());
        } catch (SolrServerException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
