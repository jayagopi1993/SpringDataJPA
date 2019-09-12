package com.rmg.SpringDataJPA.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rmg.SpringDataJPA.entities.Product;

public interface ProductRepo extends PagingAndSortingRepository<Product, Integer> {

}
