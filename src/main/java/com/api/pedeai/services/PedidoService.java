package com.api.pedeai.services;

import com.api.pedeai.models.Pedido;
import com.api.pedeai.repositories.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public List<Pedido> findAll(){
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> findById(Integer id){
        return pedidoRepository.findById(id);
    }

    @Transactional
    public Pedido save(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    @Transactional
    public void delete(Pedido pedido){
        pedidoRepository.delete(pedido);
    }
}
