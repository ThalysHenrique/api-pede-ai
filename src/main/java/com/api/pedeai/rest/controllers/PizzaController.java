package com.api.pedeai.rest.controllers;

import com.api.pedeai.exception.ResultadoException;
import com.api.pedeai.models.Pizza;
import com.api.pedeai.repositories.PizzaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    PizzaRepository pizzaRepository;

    public PizzaController(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @GetMapping
    public List<Pizza> getAllPizzas(Pizza pizza){
        return pizzaRepository.findAll();
    }

    @Transactional
    @PostMapping()
    @ResponseStatus(CREATED)
    public Pizza savePizza(@RequestBody Pizza pizza){
        return pizzaRepository.save(pizza);
    }

    @Transactional
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void deletaPizza(@PathVariable Integer id){
        pizzaRepository.findById(id)
                .map( pizzaExistente -> {
                    pizzaExistente.getId();
                    pizzaRepository.delete(pizzaExistente);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResultadoException("Pizza não encontrada."));
    }

    @Transactional
    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void alteraPizza(@PathVariable Integer id, @RequestBody Pizza pizza){
        pizzaRepository.findById(id)
                .map( pizzaExistente -> {
                    pizza.setId(pizzaExistente.getId());
                    pizzaRepository.save(pizza);
                    return pizzaExistente;
                }).orElseThrow(() -> new ResultadoException("Pizza não foi encontrada"));
    }
}
