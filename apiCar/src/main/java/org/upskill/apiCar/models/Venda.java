package org.upskill.apiCar.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Venda {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    private String compradorCliente;

    @Setter
    @Getter
    private LocalDate dataVenda;

    @Setter
    @Getter
    private BigDecimal precoVenda;


    public String getCompradorId() {
        return compradorCliente;
    }

    public void setCompradorId(String compradorCliente) {
        this.compradorCliente = compradorCliente;
    }

}
