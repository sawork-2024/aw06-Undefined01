package com.example.webpos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Data
@Entity
@AllArgsConstructor
public class Product {
    @Id
    private String id;
    private String name;
    private double price;
    private String image;
    private int quantity;

    private Product() {
    }

    @Override
    public String toString() {
        return getId() + "\t" + getName() + "\t" + getPrice();
    }

}
