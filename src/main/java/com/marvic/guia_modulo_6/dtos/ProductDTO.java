package com.marvic.guia_modulo_6.dtos;

import com.marvic.guia_modulo_6.models.Product;

public record ProductDTO(
        Long id,
        String name,
        String description,
        Double price,
        Long stock) {

    public ProductDTO (Product product){
        this(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getStock());
    }
}
