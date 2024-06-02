package com.mentoredgreg.kafkaproject.services;

import com.mentoredgreg.kafkaproject.model.BookList;
import com.mentoredgreg.kafkaproject.solr.SolrIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.mentoredgreg.kafkaproject.model.BookList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

    @Service
    public class KafkaMessageConverter {
        @Autowired
        private SolrIndex solrIndex;

        private BookList bookList = new BookList();

        @Autowired
        public KafkaMessageConverter(SolrIndex solrIndex){
            this.solrIndex = solrIndex;
        }
        public void processMessage(String message){

        }
    }
