package com.pract2.enitites;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сущность заказа
 */
public class Order {

    private final long id;

    private final String userId;

    private final LocalDateTime dateCreated;

    private final List<Product> products;

    public Order(long id, String userId, LocalDateTime dateCreated, List<Product> products) {
        this.id = id;
        this.userId = userId;
        this.dateCreated = dateCreated;
        this.products = products;
    }

    public List<Product> getProducts() {
        return products.stream().map(Product::new).collect(Collectors.toList());
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }
}
