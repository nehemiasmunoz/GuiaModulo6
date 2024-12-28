package com.marvic.guia_modulo_6.services.interfaces;

import com.marvic.guia_modulo_6.dtos.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<ProductDTO> getAllProducts();

    Optional<ProductDTO> getProductById(Long id);
}
