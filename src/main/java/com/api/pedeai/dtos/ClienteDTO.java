package com.api.pedeai.dtos;

import com.api.pedeai.models.ClienteModel;
import com.api.pedeai.models.PizzaModel;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDTO {

    private UUID id;
    @NotEmpty
    private String nomeCliente;

    @NotEmpty
    private String endereco;
    private String email;
    private LocalDateTime data;

    public ClienteDTO(ClienteModel clienteModel){
        this.id = clienteModel.getId();
        this.nomeCliente = clienteModel.getNomeCliente();
        this.endereco = clienteModel.getEndereco();
        this.email = clienteModel.getEmail();
        this.data = clienteModel.getData();
    }


}
