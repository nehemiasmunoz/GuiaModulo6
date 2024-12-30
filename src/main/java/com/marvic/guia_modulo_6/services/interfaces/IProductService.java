package com.marvic.guia_modulo_6.services.interfaces;

import com.marvic.guia_modulo_6.dtos.product.NewProductDTO;
import com.marvic.guia_modulo_6.dtos.product.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<ProductDTO> getAllProducts();

    Optional<ProductDTO> getProductById(Long id);

    void saveProduct(NewProductDTO product);

    void deleteProduct(long id);

}
