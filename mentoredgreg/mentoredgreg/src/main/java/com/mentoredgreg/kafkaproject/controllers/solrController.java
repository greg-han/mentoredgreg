package com.mentoredgreg.kafkaproject.controllers;

import com.mentoredgreg.kafkaproject.solr.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.MapSolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/solr")
public class solrController {
    @Autowired
    SolrClient solrClient;

    @GetMapping("/query")
    public ResponseEntity<String> publish (@RequestParam("Artist") String artist) throws SolrServerException, IOException {
        HttpSolrClient client = solrClient.getClient();

        final Map<String, String> queryParamMap = new HashMap<String, String>();
        queryParamMap.put("q", "Artist:" + artist);
        MapSolrParams queryParams = new MapSolrParams(queryParamMap);

        final QueryResponse response;
        try {
            response = client.query("musicCollection", queryParams);
        } catch (SolrServerException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        final SolrDocumentList documents = response.getResults();
        System.out.println("Found " + documents.getNumFound() + " documents");

        for(SolrDocument document : documents) {
            final String id = (String) document.getFirstValue("id");
            final String name = (String) document.getFirstValue("Lyric");

            System.out.println("id: " + id + "; Lyric: " + name);
        }

        return ResponseEntity.ok("We are solr-ing");
    }
}
