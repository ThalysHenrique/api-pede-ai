package com.api.pedeai.controllers;

import com.api.pedeai.exception.ResultadoException;
import com.api.pedeai.models.Pizza;
import com.api.pedeai.services.PizzaService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public List<Pizza> getAllPizzas(Pizza pizza){
        return pizzaService.findAll();
    }

    @Transactional
    @PostMapping()
    @ResponseStatus(CREATED)
    public Pizza savePizza(@RequestBody Pizza pizza){
        return pizzaService.save(pizza);
    }

    @Transactional
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void deletaPizza(@PathVariable Integer id){
        pizzaService.findById(id)
                .map( pizzaExistente -> {
                    pizzaExistente.getId();
                    pizzaService.delete(pizzaExistente);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResultadoException("Pizza não encontrada."));
    }

    @Transactional
    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void alteraPizza(@PathVariable Integer id, @RequestBody Pizza pizza){
        pizzaService.findById(id)
                .map( pizzaExistente -> {
                    pizza.setId(pizzaExistente.getId());
                    pizzaService.save(pizza);
                    return pizzaExistente;
                }).orElseThrow(() -> new ResultadoException("Pizza não foi encontrada"));
    }
}
