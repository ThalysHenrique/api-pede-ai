package com.api.pedeai;

import com.api.pedeai.models.ClienteModel;
import com.api.pedeai.models.PizzaModel;
import com.api.pedeai.repositories.ClienteRepository;
import com.api.pedeai.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@SpringBootApplication
@RestController
public class PedeAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedeAiApplication.class, args);
	}
}
