package com.api.pedeai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PedeAiApplication {
	public static void main(String[] args) {
		SpringApplication.run(PedeAiApplication.class, args);
	}

	@GetMapping("/")
	public static String mensagem(){
		return "API Pede Ai :)";
	}
}
