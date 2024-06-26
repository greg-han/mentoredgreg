package com.mentoredgreg.kafkaproject.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

    @Component
    public class KafkaProducer {

        @Value("${spring.kafka.topic.name.default}")
        private String topicName;

        private final KafkaTemplate<String, String> kafkaTemplate;
        public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate){
            this.kafkaTemplate = kafkaTemplate;
        }

        public void sendMessage(String message){
            kafkaTemplate.send(topicName, (String) message);
        }

    }
