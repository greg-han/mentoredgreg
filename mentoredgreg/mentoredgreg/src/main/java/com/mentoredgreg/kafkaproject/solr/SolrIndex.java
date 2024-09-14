package com.mentoredgreg.kafkaproject.solr;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mentoredgreg.kafkaproject.model.Song;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.client.solrj.request.UpdateRequest;
import org.apache.solr.common.params.MapSolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

    public void indexJSON(String songMessage) throws SolrServerException, IOException {
        //Change this to cloud solr
        CloudSolrClient client = solrClient.getCloudClient();
        client.connect();
        HttpSolrClient client2 = solrClient.getClient();
        ObjectMapper mapper = new ObjectMapper();
        Song songModel = mapper.readValue(songMessage, Song.class);
        System.out.println(songModel);

        //final Song song = new Song(songModel.getName(), songModel.getAlbum(), songModel.getLyrics());
        final UpdateResponse response = client.addBean("musicCollection", songModel);
        System.out.println(response);
        client.commit("musicCollection");

    }

    public void querySolr() throws SolrServerException, IOException {
        CloudSolrClient client = solrClient.getCloudClient();
        final Map<String, String> queryParamMap = new HashMap<String, String>();
        queryParamMap.put("q", "*:*");
        MapSolrParams queryParams = new MapSolrParams(queryParamMap);

        final QueryResponse response = client.query("musiCollection", queryParams);
        final SolrDocumentList documents = response.getResults();

        System.out.println("Found " + documents.getNumFound() + " documents");
        for(SolrDocument document : documents) {
            final String name = (String) document.getFirstValue("album");

            System.out.println("album: " + name);
        }
    }

}
