package com.example.webpos.db;

import org.springframework.data.repository.CrudRepository;
import com.example.webpos.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
