package org.upskill.apiCar.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.upskill.apiCar.exceptions.VeiculoNotFoundException;
import org.upskill.apiCar.models.*;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ModelRepository modelRepository;

    public Veiculo salvarVeiculo(Veiculo veiculo, Long brandId, Long modelId) {
        Brand brand = brandRepository.findById(brandId)
                .orElseThrow(() -> new RuntimeException("Marca não encontrada com ID: " + brandId));

        Model model = modelRepository.findById(modelId)
                .orElseThrow(() -> new RuntimeException("Modelo não encontrado com ID: " + modelId));

        veiculo.setBrand(brand);
        veiculo.setModel(model);

        return veiculoRepository.save(veiculo);
    }

    public Veiculo salvarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public Veiculo obterVeiculoPorId(Long id) {
        return veiculoRepository.findById(id)
                .orElseThrow(() -> new VeiculoNotFoundException("Veículo não encontrado com ID: " + id));
    }

    public List<Veiculo> listarVeiculos() {
        return veiculoRepository.findAll();
    }

    public void deletarVeiculo(Long id) {
        if (!veiculoRepository.existsById(id)) {
            throw new VeiculoNotFoundException("Veículo não encontrado com ID: " + id);
        }
        veiculoRepository.deleteById(id);
    }
}
