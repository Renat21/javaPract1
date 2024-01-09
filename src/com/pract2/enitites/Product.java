package com.pract2.enitites;

/**
 * Сущность продукта
 */
public class Product {
    private final String id;

    private final String name;

    private final String description;

    private final Double weight;

    private final Long cost;

    public Product(String id, String name, String description, Double weight, Long cost) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public Long getCost() {
        return cost;
    }

}
