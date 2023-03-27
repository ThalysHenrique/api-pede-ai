package com.api.pedeai.controllers;

import com.api.pedeai.models.PizzaModel;
import com.api.pedeai.services.PizzaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

    final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public ResponseEntity<List<PizzaModel>> getAllPizzas(PizzaModel pizzaModel){
        return ResponseEntity.status(HttpStatus.OK).body(pizzaService.findAll());
    }

    @Transactional
    @PostMapping()
    public ResponseEntity<PizzaModel> savePizza(@RequestBody PizzaModel pizzaModel){
        var pizza = new PizzaModel();
        return ResponseEntity.status(HttpStatus.OK).body(pizzaService.save(pizzaModel));
    }
}
