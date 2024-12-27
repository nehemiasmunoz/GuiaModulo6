package com.marvic.guia_modulo_6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.marvic.guia_modulo_6.services.ProductService;

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

}
