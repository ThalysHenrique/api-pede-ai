package com.api.pedeai.repositories;

import com.api.pedeai.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(value = " select * from cliente c where c.nome like '%:nome%' ", nativeQuery = true)
    List<Cliente> findByNome(@Param("nome") String nome );
    @Query(" select c from Cliente c left join fetch c.pedidos where c.id = :id  ")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);
}
