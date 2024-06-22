package com.mentoredgreg.kafkaproject.solr;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mentoredgreg.kafkaproject.model.Song;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
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

    public void indexJSON(String songMessage) throws SolrServerException, IOException {
        HttpSolrClient client = solrClient.getClient();
        ObjectMapper mapper = new ObjectMapper();
        Song songModel = mapper.readValue(songMessage, Song.class);
        System.out.println(songModel);

        //final Song song = new Song(songModel.getName(), songModel.getAlbum(), songModel.getLyrics());
        final UpdateResponse response = client.addBean("songCollection", songModel);

        client.commit("songCollection");

    }

}
