package com.mentoredgreg.kafkaproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafkaStreams;


@SpringBootApplication
public class MentoredgregApplication {
	public static void main(String[] args) {
		SpringApplication.run(MentoredgregApplication.class, args);
	}
}
