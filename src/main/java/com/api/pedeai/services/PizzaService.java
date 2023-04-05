package com.api.pedeai.services;

import com.api.pedeai.models.Pizza;
import com.api.pedeai.repositories.PizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    public List<Pizza> findAll(){
        return pizzaRepository.findAll();
    }

    public Optional<Pizza> findById(@PathVariable Integer id){
        return pizzaRepository.findById(id);
    }

    public Pizza save(Pizza pizza){
        return pizzaRepository.save(pizza);
    }

    public void delete(Pizza pizza){
        pizzaRepository.delete(pizza);
    }
}
