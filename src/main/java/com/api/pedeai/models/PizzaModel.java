package com.api.pedeai.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_PIZZA")
public class PizzaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "nome",nullable = false, length = 255)
    private String nome;
    @Column(name = "preco", nullable = false, length = 255)
    private double preco;
    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private ClienteModel clienteModel;
    }
