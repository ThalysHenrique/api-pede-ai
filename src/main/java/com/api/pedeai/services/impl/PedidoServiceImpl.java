package com.api.pedeai.services.impl;

import com.api.pedeai.dtos.PedidoDTO;
import com.api.pedeai.dtos.PizzaDTO;
import com.api.pedeai.exception.ResultadoException;
import com.api.pedeai.models.Cliente;
import com.api.pedeai.models.Pedido;
import com.api.pedeai.models.Pizza;
import com.api.pedeai.repositories.ClienteRepository;
import com.api.pedeai.repositories.PedidoRepository;
import com.api.pedeai.repositories.PizzaRepository;
import com.api.pedeai.services.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PedidoServiceImpl implements PedidoService {

    private final ClienteRepository clienteRepository;
    private final PedidoRepository pedidoRepository;
    private final PizzaRepository pizzaRepository;

    @Transactional
    @Override
    public Pedido salvar(PedidoDTO pedidoDTO) {
        Integer idCliente = pedidoDTO.getCliente();
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new ResultadoException("Cliente não foi encontrado."));

        Pedido pedido = new Pedido();
        pedido.setPrecoTotal(pedidoDTO.getTotal());
        pedido.setData(LocalDateTime.now());
        pedido.setCliente(cliente);

        List<Pizza> pizzas = converterPizza(pedido, pedidoDTO.getPizzas());
        pedidoRepository.save(pedido);
        pedido.setPizzas(pizzas);
        return pedido;
    }

    private List<Pizza> converterPizza(Pedido pedido, List<PizzaDTO> listaPizzas){
        if(listaPizzas.isEmpty()){
            throw new ResultadoException("Não é possível realizar um pedido com o carrinho vazio.");
        }

        return listaPizzas
                .stream()
                .map( pedidoDTO -> {
                    Integer idPizza = pedidoDTO.getPizza();
                    Pizza pizza = pizzaRepository.findById(idPizza)
                            .orElseThrow(() -> new ResultadoException("Código inválido " + idPizza));
                    return pizza;
                }).collect(Collectors.toList());
    }

    @Override
    public Optional<Pedido> obterPedido(Integer id) {
        return pedidoRepository.findByIdFetchItens(id);
    }
}
