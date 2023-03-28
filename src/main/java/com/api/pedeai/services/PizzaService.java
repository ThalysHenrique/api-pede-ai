package com.api.pedeai.services;

import com.api.pedeai.models.PizzaModel;
import com.api.pedeai.repositories.PizzaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PizzaService {

    final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<PizzaModel> findAll(){
        return pizzaRepository.findAll();
    }

    public Optional<PizzaModel> findById(@PathVariable UUID id){
        return pizzaRepository.findById(id);
    }

    public PizzaModel save(PizzaModel pizzaModel){
        return pizzaRepository.save(pizzaModel);
    }

    public void delete(PizzaModel pizzaModel){
        pizzaRepository.delete(pizzaModel);
    }
}
