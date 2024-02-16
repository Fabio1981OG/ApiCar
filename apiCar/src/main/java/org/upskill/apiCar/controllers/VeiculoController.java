package org.upskill.apiCar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.upskill.apiCar.Services.VeiculoService;
import org.upskill.apiCar.models.Veiculo;

import java.util.List;

@RestController
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public List<Veiculo> listarVeiculos() {
        return veiculoService.listarVeiculos();
    }

    @GetMapping("/{id}")
    public Veiculo obterVeiculoPorId(@PathVariable Long id) {
        return veiculoService.obterVeiculoPorId(id);
    }

    @PostMapping("/car")
    public Veiculo salvarVeiculo(@RequestBody Veiculo veiculo, @RequestParam Long brandId, @RequestParam Long modelId) {
        return veiculoService.salvarVeiculo(veiculo, brandId, modelId);
    }

    @DeleteMapping("/{id}")
    public void deletarVeiculo(@PathVariable Long id) {
        veiculoService.deletarVeiculo(id);
    }
}


