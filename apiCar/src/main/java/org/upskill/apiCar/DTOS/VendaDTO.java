package org.upskill.apiCar.DTOS;

import lombok.Getter;
import lombok.Setter;
import org.upskill.apiCar.models.Veiculo;
import org.upskill.apiCar.models.Seller;

public class VendaDTO {

    @Setter
    @Getter
    private Long id;
    @Setter
    @Getter
    private Veiculo veiculo;
    @Setter
    @Getter
    private Seller seller;
   private Double preco;
   private String dataVenda;


}
