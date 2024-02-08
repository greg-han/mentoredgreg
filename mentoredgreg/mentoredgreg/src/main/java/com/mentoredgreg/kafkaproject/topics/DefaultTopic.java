package com.mentoredgreg.kafkaproject.topics;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;


public class DefaultTopic {
    @Bean
    NewTopic defaultTopic() {
        return TopicBuilder.name("default")
                .partitions(10)
                .build();
    }
}