package com.example.webpos.db;

import com.example.webpos.model.Cart;

import java.util.List;

public interface PosDB {
    public Cart saveCart(Cart cart);
    public Cart getCart();
}
