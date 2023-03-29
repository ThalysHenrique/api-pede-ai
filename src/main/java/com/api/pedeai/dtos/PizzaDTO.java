package com.api.pedeai.dtos;

import com.api.pedeai.models.PizzaModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PizzaDTO {

    private UUID id;
    @NotBlank
    private String nome;
    @NotNull
    private double preco;
    private LocalDateTime data;

    public PizzaDTO(PizzaModel pizzaModel){
        this.id = pizzaModel.getId();
        this.nome = pizzaModel.getNome();
        this.preco = pizzaModel.getPreco();
        this.data = pizzaModel.getData();
    }


}
