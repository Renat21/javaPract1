package com.pract2.service;


import com.pract2.enitites.Product;
import com.pract2.service.impl.ProductsInputServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Сервис для работы с продуктами
 */
public class ProductService {

    private final ProductsInputServiceImpl productsInputService;

    public ProductService(ProductsInputServiceImpl productsInputService) {
        this.productsInputService = productsInputService;
    }

    /**
     * Метод возвращающий список обьектов продкутов по их Id
     */
    public List<Product> findProductsByIds(List<String> productIds) throws IOException {
        return Objects.requireNonNull(productsInputService).readFile().stream()
                .filter(product -> productIds.contains(product.getId())).collect(Collectors.toList());
    }
}
