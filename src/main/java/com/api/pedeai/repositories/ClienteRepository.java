package com.api.pedeai.repositories;

import com.api.pedeai.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(" select c from Cliente c left join fetch c.pedidos where c.id = :id  ")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);
}
