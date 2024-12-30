package com.marvic.guia_modulo_6.repository;

import com.marvic.guia_modulo_6.dtos.product.NewProductDTO;
import com.marvic.guia_modulo_6.models.Product;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;
    private BeanPropertyRowMapper<Product> productRowMapper = new BeanPropertyRowMapper<>(Product.class);

    ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> findAll() {
        final String sql = "select * from products";
        return jdbcTemplate.query(sql, productRowMapper);
    }

    public Optional<Product> findById(long id) {
        final String sql = "select * from products where id = ?";
        return jdbcTemplate.query(sql, productRowMapper, id).stream().findFirst();
    }

    public void save(NewProductDTO product) {
        final String sql = "insert into products (name, description, price, stock) values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, product.name(), product.description(), product.price(), product.stock());
    }

    public void delete(long id) {
        final String sql = "delete from products where id = ?";
        jdbcTemplate.update(sql, id);
    }

}
