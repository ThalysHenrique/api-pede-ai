package com.api.pedeai.controllers;

import com.api.pedeai.dtos.PizzaDTO;
import com.api.pedeai.models.PizzaModel;
import com.api.pedeai.services.PizzaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletaPizza(@PathVariable Integer id){
        Optional<PizzaModel> pizzaModelOptional = pizzaService.findById(id);
        if(!pizzaModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pizza não foi encontrada");
        }
        pizzaService.delete(pizzaModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pizza deletada com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alteraPizza(@PathVariable Integer id, @RequestBody @Valid PizzaDTO pizzaDTO){
        Optional<PizzaModel> pizzaModelOptional = pizzaService.findById(id);
        if(!pizzaModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pizza não foi encontrada.");
        }
        var pizzaModel = new PizzaModel();
        BeanUtils.copyProperties(pizzaDTO, pizzaModel);
        pizzaModel.setId(pizzaModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(pizzaService.save(pizzaModel));
    }
}
