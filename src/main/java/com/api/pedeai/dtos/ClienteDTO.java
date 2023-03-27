package com.api.pedeai.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ClienteDTO {

    @NotBlank
    private String nomeCliente;
    @NotBlank
    private String endereco;
}
