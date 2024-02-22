package org.upskill.apiCar.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.upskill.apiCar.Repository.VendaRepository;
import org.upskill.apiCar.models.Venda;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> getAllVendas() {
        return vendaRepository.findAll();
    }

    public Optional<Venda> getVendaById(Long id) {
        return vendaRepository.findById(id);
    }

    public Venda saveVenda(Venda venda) {
        return vendaRepository.save(venda);
    }

    public void deleteVenda(Long id) {
        vendaRepository.deleteById(id);
    }
}
