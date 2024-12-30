package com.marvic.guia_modulo_6.models;

import com.marvic.guia_modulo_6.dtos.ProductDTO;
import com.marvic.guia_modulo_6.dtos.product.NewProductDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long stock;

    public Product() {
    }

    public Product(Long id, String name, String description, Double price, Long stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Product(NewProductDTO newProductDTO) {
        this.name = newProductDTO.name();
        this.description = newProductDTO.description();
        this.price = newProductDTO.price();
        this.stock = newProductDTO.stock();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public ProductDTO toDTO() {
        return new ProductDTO(this.id, this.name, this.description, this.price, this.stock);
    }
}
