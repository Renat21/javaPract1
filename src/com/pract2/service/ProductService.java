package com.pract2.service;


import com.pract2.enitites.Product;
import com.pract2.service.impl.ProductsInputServiceImpl;

import java.io.IOException;
import java.util.Objects;

public class ProductService {

    private final ProductsInputServiceImpl productsInputService;

    public ProductService(ProductsInputServiceImpl productsInputService) {
        this.productsInputService = productsInputService;
    }

    public Product findProductById(String productId) throws IOException {
        return Objects.requireNonNull(productsInputService).readDefaultFile().stream()
                .filter(product -> productId.equals(product.getId())).findAny().get();
    }
}
