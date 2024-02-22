package org.upskill.apiCar.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.upskill.apiCar.Repository.ModelRepository;
import org.upskill.apiCar.models.Model;

import java.util.List;

@Service
public class ModelService {
    @Autowired
    private ModelRepository modelRepository;

    public Model salvarModel(Model model) {
        return modelRepository.save(model);
    }

    public List<Model> listarModels() {
        return modelRepository.findAll();
    }

    public Model obterModelPorId(Long id) {
        return modelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modelo não encontrado com ID: " + id));
    }

    public void deletarModel(Long id) {
        modelRepository.deleteById(id);
    }
}
