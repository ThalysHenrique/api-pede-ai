package com.api.pedeai.services;

import com.api.pedeai.models.ClienteModel;
import com.api.pedeai.repositories.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {
    final ClienteRepository clienteRepository;
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteModel> findAll(){
        return clienteRepository.findAll();
    }
    public Optional<ClienteModel> findById(UUID id){
        return clienteRepository.findById(id);
    }

    @Transactional
    public ClienteModel save(ClienteModel clienteModel){
        return clienteRepository.save(clienteModel);
    }

    @Transactional
    public void delete(ClienteModel clienteModel){
        clienteRepository.delete(clienteModel);
    }
}
