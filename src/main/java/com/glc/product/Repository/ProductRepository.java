package com.glc.product.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glc.product.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
        public List<Product> findAll();

}
