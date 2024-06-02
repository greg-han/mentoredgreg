package com.mentoredgreg.kafkaproject;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.config.TopicBuilder;

//@SpringBootApplication(scanBasePackages = {"com.mentoredgreg.kafkaproject","com.mentoredgreg.kafkaproject.services"})
@SpringBootApplication
public class MentoredgregApplication {
   //testing pointer
	public static void main(String[] args) {
		SpringApplication.run(MentoredgregApplication.class, args);
	}
}
