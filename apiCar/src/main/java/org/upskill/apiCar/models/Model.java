package org.upskill.apiCar.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.upskill.apiCar.DTOS.ModelDTO;
import org.upskill.apiCar.DTOS.VeiculoDTO;

import java.util.List;
import java.util.stream.Collectors;


@Entity
public class Model {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    private String name;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
    private List<Veiculo> veiculos;

    public Model(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public ModelDTO toDTO() {
        ModelDTO dto = new ModelDTO();
        dto.setId(this.id);
        dto.setName(this.name);

        if (this.veiculos != null) {
            dto.setVeiculos(
                    this.veiculos.stream().map(veiculo -> {
                        VeiculoDTO veiculoDTO = new VeiculoDTO();
                        veiculoDTO.setId(veiculo.getId());

                        return veiculoDTO;
                    }).collect(Collectors.toList())
            );
        }

        return dto;
    }
}
