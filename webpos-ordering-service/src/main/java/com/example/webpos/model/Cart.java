package com.example.webpos.model;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Cart {

    @Id @GeneratedValue
    private Long id;

    @OneToMany()
    private List<Item> items = new ArrayList<>();

    public boolean addItem(Item item) {
        for (var i : items) {
            if (i.getProduct().getId().equals(item.getProduct().getId())) {
                var amount = i.getQuantity() + item.getQuantity();
                if (amount <= 0) {
                    items.remove(i);
                } else {
                    i.setQuantity(amount);
                }
                return true;
            }
        }
        if (item.getQuantity() <= 0) {
            return false;
        }
        items.add(item);
        return true;
    }

    public boolean removeItem(Item item) {
        for (var i : items) {
            if (i.getProduct().getId().equals(item.getProduct().getId())) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    public double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getQuantity() * item.getProduct().getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        if (items.size() == 0) {
            return "Empty Cart";
        }
        double total = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cart -----------------\n");

        for (int i = 0; i < items.size(); i++) {
            stringBuilder.append(items.get(i).toString()).append("\n");
            total += items.get(i).getQuantity() * items.get(i).getProduct().getPrice();
        }
        stringBuilder.append("----------------------\n");

        stringBuilder.append("Total...\t\t\t" + total);

        return stringBuilder.toString();
    }
}
