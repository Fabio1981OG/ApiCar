package org.upskill.apiCar.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.upskill.apiCar.models.Veiculo;
import org.upskill.apiCar.models.VeiculoRepository;

import java.util.List;
import java.util.Optional;

/**
 * Serviço para manipulação de veículos.
 */
@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    @Autowired
    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    /**
     * Salva um veículo no banco de dados.
     * @param veiculo O veículo a ser salvo.
     * @return O veículo salvo.
     */
    public Veiculo salvarVeiculo(Veiculo veiculo) {
        // Adicione validações antes de salvar o veículo, se necessário
        return veiculoRepository.save(veiculo);
    }

    /**
     * Obtém um veículo pelo seu ID.
     * @param id O ID do veículo a ser obtido.
     * @return O veículo correspondente ao ID fornecido, ou null se não encontrado.
     */
    public Veiculo obterVeiculoPorId(Long id) {
        // Verifique se o id é válido antes de tentar buscar o veículo
        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(String.valueOf(id));
        return veiculoOptional.orElse(null);
    }

    /**
     * Lista todos os veículos no banco de dados.
     * @return Uma lista de todos os veículos.
     */
    public List<Veiculo> listarVeiculos() {
        // Você pode adicionar lógica adicional aqui, como ordenação dos veículos
        return veiculoRepository.findAll();
    }

    /**
     * Deleta um veículo do banco de dados pelo seu ID.
     * @param id O ID do veículo a ser deletado.
     * @throws IllegalArgumentException Se o veículo não for encontrado para o ID fornecido.
     */
    public void deletarVeiculo(Long id) {
        // Verifique se o veículo existe antes de tentar deletar
        if (veiculoRepository.existsById(String.valueOf(id))) {
            veiculoRepository.deleteById(String.valueOf(id));
        } else {
            throw new IllegalArgumentException("Veículo não encontrado para o ID fornecido: " + id);
        }
    }
}
