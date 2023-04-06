package com.api.pedeai.rest.controllers;

import com.api.pedeai.exception.ResultadoException;
import com.api.pedeai.models.Cliente;
import com.api.pedeai.services.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> findAllClientes(Cliente cliente){
        return clienteService.findAll();
    }

    @GetMapping("{id}")
    public Cliente findClienteById(@PathVariable Integer id){
        return clienteService.findById(id)
                .map( clienteExistente -> {
                    clienteExistente.getId();
                    return clienteExistente;
                }).orElseThrow(() -> new ResultadoException("Cliente não foi encontrado."));
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Cliente saveCliente(@RequestBody Cliente cliente){
        cliente.setData(LocalDateTime.now());
        return clienteService.save(cliente);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void deletaCliente(@PathVariable Integer id){
            clienteService.findById(id)
                .map( clienteExistente -> {
                    clienteExistente.getId();
                    clienteService.delete(clienteExistente);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResultadoException("Cliente não foi encontrado."));
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void alteraCliente(@PathVariable Integer id, @RequestBody Cliente cliente){
        clienteService.findById(id)
                .map( clienteExistente -> {
                    cliente.setId(clienteExistente.getId());
                    cliente.setData(LocalDateTime.now());
                    clienteService.save(cliente);
                    return clienteExistente;
                }).orElseThrow(() -> new ResultadoException("Cliente não foi encontrado."));
    }
}
