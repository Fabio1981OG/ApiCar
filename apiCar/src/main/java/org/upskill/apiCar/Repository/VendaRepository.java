package org.upskill.apiCar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upskill.apiCar.models.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
