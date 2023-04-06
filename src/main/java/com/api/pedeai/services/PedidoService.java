package com.api.pedeai.services;

import com.api.pedeai.dtos.PedidoDTO;
import com.api.pedeai.models.Pedido;

import java.util.Optional;

public interface PedidoService {

    Pedido salvar (PedidoDTO pedidoDTO);

    Optional<Pedido> obterPedido(Integer id);
}
