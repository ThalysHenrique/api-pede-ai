package com.api.pedeai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PedeAiApplication {
	public static void main(String[] args) {
		SpringApplication.run(PedeAiApplication.class, args);
	}
}
