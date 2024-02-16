package org.upskill.apiCar.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.upskill.apiCar.models.Brand;
import org.upskill.apiCar.models.BrandRepository;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public Brand salvarMarca(Brand brand) {
        return brandRepository.save(brand);
    }

    // Outros métodos do serviço, se necessário
}