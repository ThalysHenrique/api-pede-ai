package com.api.pedeai.rest.controllers;

import com.api.pedeai.dtos.InformacoesPedidoDTO;
import com.api.pedeai.dtos.InformacoesPizzaDTO;
import com.api.pedeai.dtos.PedidoDTO;
import com.api.pedeai.models.Pedido;
import com.api.pedeai.models.Pizza;
import com.api.pedeai.services.PedidoService;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer savePedido(@RequestBody PedidoDTO pedidoDTO){
        Pedido pedido = pedidoService.salvar(pedidoDTO);
        return pedido.getId();
    }

    @GetMapping("{id}")
    public InformacoesPedidoDTO getById(@PathVariable Integer id){
        return pedidoService.obterPedido(id)
                .map( pedidoExistente -> converter(pedidoExistente) )
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Pedido não foi encontrado."));
    }

    private InformacoesPedidoDTO converter(Pedido pedido){
         return InformacoesPedidoDTO
                 .builder().codigo(pedido.getId())
                 .dataPedido(LocalDateTime.now())
                 .cpf(pedido.getCliente().getCpf())
                 .nomeCliente(pedido.getCliente().getNome())
                 .total(pedido.getPrecoTotal())
                 .pizzas(converter(pedido.getPizzas()))
                 .build();
    }

    private List<InformacoesPizzaDTO> converter(List<Pizza> listaPizza){
        if(CollectionUtils.isEmpty(listaPizza)){
            return Collections.emptyList();
        }

        return listaPizza.stream().map(
                pizza -> InformacoesPizzaDTO
                        .builder().nomePizza(pizza.getNome())
                        .precoUnitario(pizza.getPreco())
                        .quantidade(pizza.getQuantidade())
                        .build())
                .collect(Collectors.toList());
    }
}
