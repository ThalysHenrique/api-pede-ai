package com.api.pedeai.services;

import com.api.pedeai.models.PedidoModel;
import com.api.pedeai.repositories.PedidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PedidoService {

    final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<PedidoModel> findAll(){
        return pedidoRepository.findAll();
    }

    public Optional<PedidoModel> findById(UUID id){
        return pedidoRepository.findById(id);
    }

    @Transactional
    public PedidoModel save(PedidoModel pedidoModel){
        return pedidoRepository.save(pedidoModel);
    }

    @Transactional
    public void delete(PedidoModel pedidoModel){
        pedidoRepository.delete(pedidoModel);
    }
}
