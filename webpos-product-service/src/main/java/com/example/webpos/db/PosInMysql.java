package com.example.webpos.db;

import com.example.webpos.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class PosInMysql implements PosDB {
    @Autowired
    private ProductRepository productRepository;

    private List<Product> products = null;

    @Override
    public List<Product> getProducts() {
        initProduct();
        return products;
    }

    @Override
    public Product getProduct(String productId) {
        initProduct();
        for (Product p : getProducts()) {
            if (p.getId().equals(productId)) {
                return p;
            }
        }
        return null;
    }

    private void initProduct() {
        if (this.products != null) {
            return;
        }
        
        this.products = new ArrayList<>();
        productRepository.findAll().forEach(this.products::add);
    }
}
