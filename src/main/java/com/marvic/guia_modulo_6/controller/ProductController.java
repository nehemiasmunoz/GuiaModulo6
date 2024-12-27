package com.marvic.guia_modulo_6.controller;

import com.marvic.guia_modulo_6.dtos.ProductDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.marvic.guia_modulo_6.services.ProductService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping()
    public String getAllProduct(Model model) {
        model.addAttribute("productList", service.getAllProducts());
        return "product_list" ;
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable long id, Model model) {
        Optional<ProductDTO> product = service.getProductById(id);
        if (product.isPresent()) {
            model.addAttribute("productList", List.of(product.get()));
        } else {
            model.addAttribute("error", "Producto no encontrado");
            model.addAttribute("productList", List.of());
        }
        return "product_list";
    }

}
