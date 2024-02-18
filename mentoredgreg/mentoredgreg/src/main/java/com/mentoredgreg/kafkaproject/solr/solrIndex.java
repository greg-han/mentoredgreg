package com.mentoredgreg.kafkaproject.solr;

import org.apache.solr.client.solrj.impl.Http2SolrClient;
import org.apache.solr.common.SolrInputDocument;

public class solrIndex {
    Http2SolrClient client = solrClient.getClient();
    SolrInputDocument inputDoc = new SolrInputDocument();

}
