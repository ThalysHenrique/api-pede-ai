package com.api.pedeai.repositories;

import com.api.pedeai.models.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {


}
