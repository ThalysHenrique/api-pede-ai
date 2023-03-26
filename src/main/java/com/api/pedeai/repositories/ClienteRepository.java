package com.api.pedeai.repositories;

import com.api.pedeai.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {

    boolean existsByNomeCliente(String nomeCliente);
}
