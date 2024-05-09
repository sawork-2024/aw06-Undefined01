package com.example.webpos.db;

import org.springframework.data.repository.CrudRepository;
import com.example.webpos.model.Cart;

public interface CartRepository extends CrudRepository<Cart, Long> {
}
