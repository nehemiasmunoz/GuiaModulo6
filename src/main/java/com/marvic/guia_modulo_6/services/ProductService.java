package com.marvic.guia_modulo_6.services;

import com.marvic.guia_modulo_6.dtos.ProductDTO;
import com.marvic.guia_modulo_6.dtos.product.NewProductDTO;
import com.marvic.guia_modulo_6.models.Product;
import com.marvic.guia_modulo_6.repository.ProductRepository;
import com.marvic.guia_modulo_6.services.interfaces.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// Anotacion que indica a springboot que esta clase sera un servicio y puede ser
// administrada por el
@Service
public class ProductService implements IProductService {
    private ProductRepository productRepository;

    ProductService(ProductRepository repository) {
        this.productRepository = repository;
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<ProductDTO> getProductById(Long id) {
        Optional<Product> productdb = productRepository.findById(id);
        if (productdb.isPresent()) {
            return Optional.of(new ProductDTO(productdb.get()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void saveProduct(NewProductDTO product) {
        productRepository.save(new Product(product));
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

}
