package com.api.pedeai.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteDTO {

    @NotBlank
    private String nomeCliente;
    @NotBlank
    private String endereco;
}
