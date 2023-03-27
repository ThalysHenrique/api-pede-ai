package com.api.pedeai.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PizzaDTO {

    @NotBlank
    private String nome;
    @NotNull
    private double preco;
}
