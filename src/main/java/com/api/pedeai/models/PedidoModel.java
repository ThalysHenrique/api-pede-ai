package com.api.pedeai.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_PEDIDO")
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "data", nullable = false)
    private LocalDateTime data;

    @ManyToOne
    private ClienteModel clientes;

    @OneToMany(mappedBy = "pedidosModel")
    private List<PizzaModel> pizzas = new LinkedList<>();
}
