package com.api.pedeai.repositories;

import com.api.pedeai.models.Cliente;
import com.api.pedeai.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);

    @Query(" select p from Pedido p left join fetch p.pizzas where p.id = :id ")
    Optional<Pedido> findByIdFetchItens(@Param("id") Integer id);
}
