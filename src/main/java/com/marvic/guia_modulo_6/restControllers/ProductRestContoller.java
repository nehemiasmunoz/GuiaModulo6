package com.marvic.guia_modulo_6.restControllers;

import com.marvic.guia_modulo_6.dtos.ProductDTO;
import com.marvic.guia_modulo_6.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/products") // Establecemos una ruta base para nuestro controller
public class ProductRestContoller {

    // Creamos una propiedad de product service
    private final ProductService productService;

    ProductRestContoller(ProductService service) {
        // Injectamos mediante constructor el servicio a nuestro controlador
        this.productService = service;
    }

    @GetMapping("/list")
    public List<ProductDTO> getMethodName() {
        return productService.getAllProducts();
    }

}
