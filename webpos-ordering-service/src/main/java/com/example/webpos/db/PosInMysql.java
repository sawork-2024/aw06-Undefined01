package com.example.webpos.db;

import com.example.webpos.model.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class PosInMysql implements PosDB {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ItemRepository itemRepository;

    Cart cart = null;

    @Override
    public Cart saveCart(Cart cart) {
        if (this.cart == null || cart.getId() != this.cart.getId()) {
            cartRepository.deleteAll();
            itemRepository.saveAll(cart.getItems());
            this.cart = cartRepository.save(cart);
            return this.cart;
        } else {
            itemRepository.saveAll(cart.getItems());
            this.cart = cartRepository.save(cart);
            return this.cart;
        }
    }

    @Override
    public Cart getCart() {
        if (this.cart == null) {
            var carts = cartRepository.findAll().iterator();
            if (carts.hasNext()) {
                this.cart = carts.next();
                System.out.println("Get cart from database: " + cart.getId() + "\n" + cart);
            } else {
                this.cart = cartRepository.save(new Cart());
            }
        }
        return cart;
    }
}
