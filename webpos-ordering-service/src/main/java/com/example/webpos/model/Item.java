package com.example.webpos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;

@Data
@Entity
public class Item {
    @Id @GeneratedValue
    private Long id;
  
    @ManyToOne
    private Product product;
    private int quantity;

    private Item() {
    }

    public Item(Product product, int quantity) {
      this.product = product;
      this.quantity = quantity;
    }

    @Override
    public String toString() {
        return product.toString() + "\t" + quantity;
    }
}
