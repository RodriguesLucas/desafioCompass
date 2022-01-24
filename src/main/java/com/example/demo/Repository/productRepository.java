package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.ProductEntity;

public interface productRepository extends JpaRepository<ProductEntity, Long>{

}
