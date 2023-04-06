package com.api.pedeai.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pizza")
public class Pizza implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "nome", length = 100)
    private String nome;
    @Column(name = "preco")
    private BigDecimal preco;
    @Column(name = "quantidade")
    private Integer quantidade;

    }
