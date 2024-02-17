package com.mentoredgreg.kafkaproject.solr;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.request.CoreAdminRequest;

import java.io.IOException;


public class solrCore {
    String testCore = "testCore";
    public static void getNewCore(String coreName) throws SolrServerException, IOException {
        CoreAdminRequest.Create newCore = new CoreAdminRequest.Create();
        newCore.setCoreName(coreName);
        try {
            newCore.process(solrClient.getClient());
        } catch (SolrServerException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
