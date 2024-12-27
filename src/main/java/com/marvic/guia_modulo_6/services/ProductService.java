package com.marvic.guia_modulo_6.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.marvic.guia_modulo_6.dtos.ProductDTO;
import org.springframework.stereotype.Service;

import com.marvic.guia_modulo_6.models.Product;

// Anotacion que indica a springboot que esta clase sera un servicio y puede ser
// administrada por el
@Service
public class ProductService {
    ArrayList<Product> products = new ArrayList<>();

    ProductService() {
        // Agregamos productos simulando una tabla con datos
        products.add(new Product(1L, "Zapatos", "Zapatos de cuero", 42.000, 40L));
        products.add(new Product(2L, "Zapatos", "Zapatos de cuero", 42.000, 40L));
        products.add(new Product(3L, "Cartera", "Cartera de cuero color negro", 20.000, 20L));
    }

    public List<ProductDTO> getAllProducts() {
        return products.stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<ProductDTO> getProductById(Long id) {
        Optional<Product> productdb = products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
        if (productdb.isPresent()) {
            return Optional.of(new ProductDTO(productdb.get()));
        }else{
            return Optional.empty();
        }
    }

}
