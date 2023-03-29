package com.api.pedeai.controllers;

import com.api.pedeai.models.PedidoModel;
import com.api.pedeai.services.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }


    @GetMapping
    public ResponseEntity<List<PedidoModel>> getAllPedidos(PedidoModel pedidoModel){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id")UUID id){
        Optional<PedidoModel> pedidoModelOptional = pedidoService.findById(id);
        if(pedidoModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pedidoModelOptional);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<PedidoModel> save(@RequestBody PedidoModel pedidoModel){
        var pedido = new PedidoModel();
        pedidoModel.setData(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.save(pedido));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id){
        Optional<PedidoModel> pedidoModelOptional = pedidoService.findById(id);
        if(pedidoModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado.");
        }
        pedidoService.delete(pedidoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pedido deletado com sucesso.");
    }
}
