package com.api.pedeai.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_CLIENTE")
public class ClienteModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome", nullable = false, length = 255)
    private String nomeCliente;
    @Column(name = "endereco", nullable = false, length = 255)
    private String endereco;
    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime data;
}
