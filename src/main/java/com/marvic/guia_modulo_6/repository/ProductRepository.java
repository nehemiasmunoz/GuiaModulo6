package com.marvic.guia_modulo_6.repository;

import com.marvic.guia_modulo_6.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
