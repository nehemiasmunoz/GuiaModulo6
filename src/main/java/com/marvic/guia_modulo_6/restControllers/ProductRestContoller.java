package com.marvic.guia_modulo_6.restControllers;

import com.marvic.guia_modulo_6.dtos.product.NewProductDTO;
import com.marvic.guia_modulo_6.dtos.product.ProductDTO;
import com.marvic.guia_modulo_6.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/products") // Establecemos una ruta base para nuestro controller
public class ProductRestContoller {

    // Creamos una propiedad de product service
    private final ProductService productService;

    ProductRestContoller(ProductService service) {
        // Injectamos mediante constructor el servicio a nuestro controlador
        this.productService = service;
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable long id) {
        Optional<ProductDTO> productDTO = productService.getProductById(id);
        if (productDTO.isPresent()) {
            return productDTO.get();
        } else {
            return null;
        }
    }

    @PostMapping("/save")
    public void saveProduct(@RequestBody NewProductDTO newProductDTO) {
        productService.saveProduct(newProductDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
    }


}
