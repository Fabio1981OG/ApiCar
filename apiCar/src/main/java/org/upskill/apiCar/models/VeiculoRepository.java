package org.upskill.apiCar.models;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface de repositório para operações de banco de dados relacionadas à entidade Veiculo.
 */
public interface VeiculoRepository extends JpaRepository<Veiculo, String> {
}
