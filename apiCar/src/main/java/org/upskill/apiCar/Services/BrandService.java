package org.upskill.apiCar.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.upskill.apiCar.DTOS.BrandDTO;
import org.upskill.apiCar.Repository.BrandRepository;
import org.upskill.apiCar.models.Brand;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public Brand salvarMarca(Brand brand) {
        return brandRepository.save(brand);
    }

    public BrandDTO getBrandDetails(Long brandId) {
        Brand brand = brandRepository.findById(brandId).orElse(null);
        if (brand != null) {
            return brand.toDTO();
        }
        return null;
    }


}
