package org.upskill.apiCar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.upskill.apiCar.Services.BrandService;
import org.upskill.apiCar.models.Brand;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    public Brand criarMarca(@RequestBody Brand brand) {
        return brandService.salvarMarca(brand);
    }

}