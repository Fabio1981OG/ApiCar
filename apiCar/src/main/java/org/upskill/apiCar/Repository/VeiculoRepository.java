package org.upskill.apiCar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upskill.apiCar.models.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {


}