package com.pract2.enitites;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Сущность заказа
 */
public class Order {

    private final String id;

    private final String userId;

    private final LocalDateTime dateCreated;

    private final List<Product> products;

    public Order(String id, String userId, LocalDateTime dateCreated, List<Product> products) {
        this.id = id;
        this.userId = userId;
        this.dateCreated = dateCreated;
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }
}
