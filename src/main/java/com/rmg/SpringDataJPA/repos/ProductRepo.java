package com.rmg.SpringDataJPA.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmg.SpringDataJPA.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
