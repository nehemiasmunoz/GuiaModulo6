package com.marvic.guia_modulo_6.dtos;

public record ProductDTO(
        Long id,
        String name,
        String description,
        Double price,
        Long stock) {

}
