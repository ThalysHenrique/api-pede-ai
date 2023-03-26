package com.api.pedeai.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "TB_CLIENTE")
public class ClienteModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome", nullable = false, length = 255)
    @NotEmpty(message = "Nome do cliente é obrigatório.")
    private String nomeCliente;

    public ClienteModel(Integer id, String nomeCliente){
        this.id = id;
        this.nomeCliente = nomeCliente;
    }
}
