package org.upskill.apiCar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.upskill.apiCar.Services.ModelService;
import org.upskill.apiCar.models.Model;

import java.util.List;

@RestController
@RequestMapping("/models")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @GetMapping
    public List<Model> listarModels() {
        return modelService.listarModels();
    }

    @GetMapping("/{id}")
    public Model obterModelPorId(@PathVariable Long id) {
        return modelService.obterModelPorId(id);
    }

    @PostMapping
    public Model salvarModel(@RequestBody Model model) {
        return modelService.salvarModel(model);
    }

    @PutMapping("/{id}")
    public Model atualizarModel(@PathVariable Long id, @RequestBody Model model) {
        // Certifique-se de definir o ID no modelo a ser atualizado
        model.setId(id);
        return modelService.salvarModel(model);
    }

    @DeleteMapping("/{id}")
    public void deletarModel(@PathVariable Long id) {
        modelService.deletarModel(id);
    }
}