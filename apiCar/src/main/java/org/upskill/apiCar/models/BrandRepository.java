package org.upskill.apiCar.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upskill.apiCar.models.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {

}