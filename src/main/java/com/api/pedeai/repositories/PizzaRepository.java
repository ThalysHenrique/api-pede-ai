package com.api.pedeai.repositories;

import com.api.pedeai.models.PizzaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<PizzaModel, Integer> {


}
