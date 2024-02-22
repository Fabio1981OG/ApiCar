package org.upskill.apiCar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upskill.apiCar.models.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
