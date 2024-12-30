package com.marvic.guia_modulo_6.dtos.product;

public record NewProductDTO(
        String name,
        String description,
        Double price,
        Long stock
) {
}
