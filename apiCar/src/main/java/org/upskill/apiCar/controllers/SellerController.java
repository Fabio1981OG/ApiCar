package org.upskill.apiCar.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upskill.apiCar.DTOS.SellerDTO;
import org.upskill.apiCar.Services.SellerService;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<SellerDTO>>> getAllSellers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {
        Page<SellerDTO> sellersPage = sellerService.getAllSellers(page, size);

        List<EntityModel<SellerDTO>> sellerModels = sellersPage.getContent().stream()
                .map(seller -> EntityModel.of(seller,
                        linkTo(methodOn(SellerController.class).getSellerById(seller.getId())).withRel("seller")))
                .collect(Collectors.toList());

        PagedModel<EntityModel<SellerDTO>> pagedModel = PagedModel.of(sellerModels,
                new PagedModel.PageMetadata(sellersPage.getSize(), sellersPage.getNumber(), sellersPage.getTotalElements()));

        pagedModel.add(linkTo(methodOn(SellerController.class).getAllSellers(page, size)).withSelfRel());

        return new ResponseEntity<>(pagedModel, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public SellerDTO getSellerById(@PathVariable Long id) {
        return sellerService.getSellerById(id).orElse(null);
    }

    @PostMapping("/new")
    public SellerDTO saveSeller(@RequestBody SellerDTO sellerDTO) {
        return sellerService.saveSeller(sellerDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSeller(@PathVariable Long id) {
        sellerService.deleteSeller(id);
    }
}