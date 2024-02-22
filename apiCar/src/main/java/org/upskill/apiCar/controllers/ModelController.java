package org.upskill.apiCar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.upskill.apiCar.Services.ModelService;
import org.upskill.apiCar.models.Model;

@RestController
@RequestMapping("/models")
public class ModelController {

    @Autowired
    private ModelService modelService;


    @PostMapping("/")
    public Model criarMarca(@RequestBody Model model) {
        return modelService.salvarModel(model);
    }

}
