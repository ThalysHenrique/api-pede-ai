package com.api.pedeai.controllers;

import com.api.pedeai.models.ClienteModel;
import com.api.pedeai.services.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    final ClienteService clienteService;
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Object> saveCliente(@RequestBody ClienteModel clienteModel){
        var cliente = new ClienteModel();
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteModel));
    }
}
