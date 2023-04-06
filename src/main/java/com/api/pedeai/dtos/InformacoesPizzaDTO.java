package com.api.pedeai.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformacoesPizzaDTO {

    private String nomePizza;
    private BigDecimal precoUnitario;
    private Integer quantidade;
}
