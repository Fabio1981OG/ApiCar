package org.upskill.apiCar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upskill.apiCar.models.Model;

public interface ModelRepository extends JpaRepository<Model, Long> {

}