package com.pract2.enitites;

/**
 * Сущность продукта
 */
public class Product {
    private final long id;

    private final String name;

    private final String description;

    private final double weight;

    private final Long cost;

    public Product(long id, String name, String description, Double weight, Long cost) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.cost = cost;
    }

    public Product(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.weight = product.getWeight();
        this.cost = product.getCost();
    }

    public long getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getCost() {
        return cost;
    }

}
