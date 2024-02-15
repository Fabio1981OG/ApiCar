package org.upskill.apiCar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.upskill.apiCar.Services.VeiculoService;
import org.upskill.apiCar.models.Veiculo;

import java.util.List;

/**
 * Controlador para manipulação de veículos.
 */
@RestController
@RequestMapping("/veiculos") // Define o prefixo para todos os endpoints neste controlador
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    /**
     * Retorna uma lista de todos os veículos.
     * @return Lista de veículos.
     */
    @GetMapping
    public List<Veiculo> listarVeiculos() {
        return veiculoService.listarVeiculos();
    }

    /**
     * Retorna um veículo por ID.
     * @param id ID do veículo a ser recuperado.
     * @return Veículo correspondente ao ID fornecido.
     */
    @GetMapping("/{id}")
    public Veiculo obterVeiculoPorId(@PathVariable Long id) {
        return veiculoService.obterVeiculoPorId(id);
    }

    /**
     * Cria um novo veículo.
     * @param veiculo Objeto Veiculo a ser criado.
     * @return Veículo recém-criado.
     */
    @PostMapping("/criar")
    public Veiculo salvarVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoService.salvarVeiculo(veiculo);
    }

    /**
     * Exclui um veículo por ID.
     * @param id ID do veículo a ser excluído.
     */
    @DeleteMapping("/{id}")
    public void deletarVeiculo(@PathVariable Long id) {
        veiculoService.deletarVeiculo(id);
    }
}
