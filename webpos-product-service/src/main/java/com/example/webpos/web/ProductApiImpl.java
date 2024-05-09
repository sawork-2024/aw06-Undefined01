package com.example.webpos.web;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.webpos.db.PosDB;
import com.example.webpos.model.Product;
import com.example.webpos.model.ProductDto;

@Component
public class ProductApiImpl implements ProductApiDelegate {

    @Autowired
    private PosDB posDB;

    @Override
    public ResponseEntity<List<ProductDto>> listProducts() {
        return ResponseEntity.ok(posDB.getProducts().stream()
            .map(this::toProductDto)
            .toList());
    }

    @Override
    public ResponseEntity<ProductDto> showProductById(String productId) {
        var p = posDB.getProducts().stream()
            .filter(product -> product.getId().equals(productId))
            .findFirst()
            .orElse(null);
        if (p == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toProductDto(p));
    }

    @Override
    public ResponseEntity<ProductDto> updateProduct(String productId, Integer quantity) {
        var p = posDB.getProducts().stream()
            .filter(product -> product.getId().equals(productId))
            .findFirst()
            .orElse(null);
        if (p == null) {
            return ResponseEntity.notFound().build();
        }
        p.setQuantity(quantity);
        return ResponseEntity.ok(toProductDto(p));
    }

    private ProductDto toProductDto(Product product) {
        return new ProductDto()
            .id(product.getId())
            .name(product.getName())
            .price(product.getPrice())
            .stock(1)
            .quantity(product.getQuantity())
            .image(product.getImage());
    }
}
