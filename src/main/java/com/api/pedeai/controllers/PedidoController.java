package com.api.pedeai.controllers;

import com.api.pedeai.exception.ResultadoException;
import com.api.pedeai.models.Pedido;
import com.api.pedeai.services.PedidoService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }


    @GetMapping
    public List<Pedido> findAllPedidos(Pedido pedido){
        return pedidoService.findAll();
    }

    @GetMapping("{id}")
    public Pedido findPedidoById(@PathVariable Integer id) {
        return pedidoService.findById(id)
                .map(pedidoExistente -> {
                    pedidoExistente.getId();
                    return pedidoExistente;
                }).orElseThrow(() -> new ResultadoException("Pedido não encontrado"));
    }

    @Transactional
    @PostMapping
    @ResponseStatus(CREATED)
    public Pedido savePedido(@RequestBody Pedido pedido){
        return pedidoService.save(pedido);
    }

    @Transactional
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id){
        pedidoService.findById(id)
                .map( pedidoExistente -> {
                    pedidoExistente.getId();
                    pedidoService.delete(pedidoExistente);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResultadoException("Pedido não encontrado"));
    }
}
