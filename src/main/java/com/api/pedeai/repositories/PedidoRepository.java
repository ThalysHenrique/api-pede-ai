package com.api.pedeai.repositories;

import com.api.pedeai.models.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidoRepository extends JpaRepository<PedidoModel, UUID> {


}
