package com.pract2.enitites;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private String id;

    private String userId;

    private LocalDateTime dateCreated;

    private List<Product> products;

    public Order(){};

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
