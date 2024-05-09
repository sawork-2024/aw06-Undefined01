package com.example.webpos.biz;

import com.example.webpos.db.PosDB;
import com.example.webpos.model.Cart;
import com.example.webpos.model.Item;
import com.example.webpos.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Random;

@Component
public class PosServiceImp implements PosService {

    @Autowired
    private PosDB posDB;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    private Random random = new Random();

    @Override
    public Cart getCart() {

        Cart cart = posDB.getCart();
        if (cart == null) {
            cart = this.newCart();
        }
        return cart;
    }

    @Override
    public Cart newCart() {
        return posDB.saveCart(new Cart());
    }

    @Override
    public void checkout(Cart cart) {
        newCart();
    }

    @Override
    public double total(Cart cart) {
        return cart.calculateTotal();
    }

    @Override
    public boolean add(Product product, int amount) {
        if (product == null)
            return false;

        this.getCart().addItem(new Item(product, amount));
        posDB.saveCart(this.getCart());
        return true;
    }

    @Override
    public boolean add(String productId, int amount) {
        Product product = getProduct(productId);
        return add(product, amount);
    }

    @Override
    public boolean remove(String productId) {
        Product product = getProduct(productId);
        if (product == null)
            return false;
        this.getCart().removeItem(new Item(product, 0));
        posDB.saveCart(this.getCart());
        return true;
    }

    private Product getProduct(String productId) {
        var instances = discoveryClient.getInstances("webpos-product-service");
        if (instances.size() == 0) {
            return null;
        }
        var instance = instances.get(random.nextInt(instances.size()));
        String serviceUri = String.format("%s/product/%s", instance.getUri().toString(), productId);
        try {
            var response = restTemplate.exchange(serviceUri, HttpMethod.GET, null, Product.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            return null;
        }
    }
}
