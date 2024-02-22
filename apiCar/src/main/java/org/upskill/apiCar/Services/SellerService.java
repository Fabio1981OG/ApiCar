package org.upskill.apiCar.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.upskill.apiCar.DTOS.SellerDTO;
import org.upskill.apiCar.Repository.SellerRepository;
import org.upskill.apiCar.models.Seller;

import java.util.Optional;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;


    public Page<SellerDTO> getAllSellers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Seller> sellers = sellerRepository.findAll(pageable);
        return sellers.map(this::convertToDTO);
    }
    public Optional<SellerDTO> getSellerById(Long id) {
        return sellerRepository.findById(id)
                .map(this::convertToDTO);
    }

    public SellerDTO saveSeller(SellerDTO sellerDTO) {
        Seller seller = convertToEntity(sellerDTO);
        Seller savedSeller = sellerRepository.save(seller);
        return convertToDTO(savedSeller);
    }

    public void deleteSeller(Long id) {
        sellerRepository.deleteById(id);
    }

    private SellerDTO convertToDTO(Seller seller) {

        SellerDTO sellerDTO = new SellerDTO(

                seller.getName(),
                seller.getEmail(),
                seller.getPhone()
        );
        sellerDTO.setId(seller.getId());
        return sellerDTO;
    }

    private Seller convertToEntity(SellerDTO sellerDTO) {
        Seller seller = new Seller();
        seller.setId(sellerDTO.getId());
        seller.setName(sellerDTO.getName());
        seller.setEmail(sellerDTO.getEmail());
        seller.setPhone(sellerDTO.getPhone());
        return seller;
    }
}
