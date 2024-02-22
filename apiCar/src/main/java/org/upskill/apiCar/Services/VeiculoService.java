package org.upskill.apiCar.Services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.upskill.apiCar.Exceptions.VeiculoNotFoundException;
import org.upskill.apiCar.Repository.BrandRepository;
import org.upskill.apiCar.Repository.ModelRepository;
import org.upskill.apiCar.Repository.SellerRepository;
import org.upskill.apiCar.Repository.VeiculoRepository;
import org.upskill.apiCar.models.Brand;
import org.upskill.apiCar.models.Model;
import org.upskill.apiCar.models.Seller;
import org.upskill.apiCar.models.Veiculo;

import java.util.List;
import java.util.Optional;

@Service

public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private SellerRepository sellerRepository;

    public Veiculo salvarVeiculo(Veiculo veiculo, Long brandId, Long modelId,Long sellerId ) {
        Brand brand = brandRepository.findById(brandId).orElseThrow(() -> new EntityNotFoundException("Marca não encontrada"));
        Model model = modelRepository.findById(modelId).orElseThrow(() -> new EntityNotFoundException("Modelo não encontrado"));
        Seller seller = sellerRepository.findById(sellerId).orElseThrow(() -> new EntityNotFoundException("Seller não encontrado"));


        veiculo.setBrand(brand);
        veiculo.setModel(model);
        veiculo.setSeller(seller);

        return veiculoRepository.save(veiculo);
    }
    public Veiculo salvarVeiculo(Veiculo veiculo) {
        try {

            Veiculo veiculoSalvo = veiculoRepository.save(veiculo);
            return veiculoSalvo;
        } catch (Exception e) {

            throw new RuntimeException("Erro ao salvar o veículo", e);
        }
    }

    public Veiculo obterVeiculoPorId(Long id) {
        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);
        return (Veiculo) ((Optional<?>) veiculoOptional).orElseThrow(() -> new VeiculoNotFoundException("Veículo não encontrado com ID: " + id));
    }

    public List<Veiculo> listarVeiculos() {
        return veiculoRepository.findAll();
    }

    public void deletarVeiculo(Long id) {
        try {
            veiculoRepository.deleteById(id);
        } catch (Exception e) {

            throw new RuntimeException("Erro ao deletar o veículo com ID: " + id, e);
        }
    }
}
