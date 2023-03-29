package com.api.pedeai.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    @NotEmpty
    private UUID id;
    @NotEmpty
    private LocalDateTime data;


}
