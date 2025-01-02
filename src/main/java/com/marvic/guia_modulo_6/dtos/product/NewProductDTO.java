package com.marvic.guia_modulo_6.dtos.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record NewProductDTO(
        @NotBlank //No debe estar en blanco o vacio
        String name,
        @NotBlank
        String description,
        @NotNull
        @Positive //Debe ser positivo
        Double price,
        @NotNull
        @Min(0) // Debe ser un valor minimo de 0
        Long stock
) {
}
