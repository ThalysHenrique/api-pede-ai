package com.api.pedeai.services;

import com.api.pedeai.models.Cliente;
import com.api.pedeai.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }
    public Optional<Cliente> findById(Integer id){
        return clienteRepository.findById(id);
    }

    @Transactional
    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void delete(Cliente cliente){
        clienteRepository.delete(cliente);
    }
}
