package com.example.webpos.web;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.webpos.biz.PosService;
import com.example.webpos.model.Product;
import com.example.webpos.model.ProductDto;
import com.example.webpos.model.Item;
import com.example.webpos.model.CartItemDto;

@Component
public class CartApiImpl implements CartApiDelegate {

    @Autowired
    private PosService posService;

    @Override
    public ResponseEntity<List<CartItemDto>> getCart() {
        return ResponseEntity.ok(posService.getCart().getItems().stream()
            .map(this::toCartItemDto)
            .toList());
    }

    @Override
    public ResponseEntity<List<CartItemDto>> addToCart(String productId, Integer quantity) {
        System.out.println("Adding " + quantity + " of " + productId);
        var res = posService.add(productId, quantity);
        if (!res) {
            return ResponseEntity.badRequest().build();
        }
        return getCart();
    }

    @Override 
    public ResponseEntity<List<CartItemDto>> removeFromCart(String productId) {
        var res = posService.remove(productId);
        if (!res) {
            return ResponseEntity.badRequest().build();
        }
        return getCart();
    }

    @Override
    public ResponseEntity<List<CartItemDto>> updateCart(String productId, Integer quantity) {
        var res = posService.remove(productId);
        if (!res) {
            return ResponseEntity.badRequest().build();
        }
        res = posService.add(productId, quantity);
        if (!res) {
            return ResponseEntity.badRequest().build();
        }
        return getCart();
    }

    private CartItemDto toCartItemDto(Item item) {
        return new CartItemDto()
            .productId(item.getProduct().getId())
            .quantity(item.getQuantity());
    }

    private ProductDto toProductDto(Product product) {
        return new ProductDto()
            .id(product.getId())
            .name(product.getName())
            .price(product.getPrice())
            .stock(product.getQuantity() >= 0 ? 1 : 0)
            .quantity(product.getQuantity())
            .image(product.getImage());
    }
}
