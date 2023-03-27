package com.api.pedeai.controllers;

import com.api.pedeai.dtos.ClienteDTO;
import com.api.pedeai.models.ClienteModel;
import com.api.pedeai.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    final ClienteService clienteService;
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteModel>> getAllClientes(ClienteModel clienteModel){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getClienteById(@PathVariable Integer id){
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
        if(!clienteModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não foi encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteModelOptional.get());
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Object> saveCliente(@RequestBody ClienteModel clienteModel){
        var cliente = new ClienteModel();
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteModel));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletaCliente(@PathVariable Integer id){
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
        if(!clienteModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não foi encontrado.");
        }
        clienteService.delete(clienteModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alteraCliente(@PathVariable Integer id, @RequestBody @Valid ClienteDTO clienteDTO){
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
        if(!clienteModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não foi encontrado.");
        }
        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDTO, clienteModel);
        clienteModel.setId(clienteModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(clienteModel));
    }
}
