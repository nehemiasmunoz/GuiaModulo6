package com.marvic.guia_modulo_6.restControllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marvic.guia_modulo_6.models.Product;
import com.marvic.guia_modulo_6.services.ProductService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

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
    public List<Product> getMethodName() {
        return productService.getAllProducts();
    }

}
