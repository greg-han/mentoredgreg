package com.mentoredgreg.kafkaproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.mentoredgreg.kafkaproject"})
public class MentoredgregApplication {

	public static void main(String[] args) {
		SpringApplication.run(MentoredgregApplication.class, args);
	}

}
