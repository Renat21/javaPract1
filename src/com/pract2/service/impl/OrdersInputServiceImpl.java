package com.pract2.service.impl;

import com.pract2.enitites.Order;
import com.pract2.enitites.Product;
import com.pract2.service.InputService;
import com.pract2.service.ProductService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Реализация чтения из файлов пдля заказов
 */
public class OrdersInputServiceImpl extends InputService<Order> {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    private ProductService productService;

    public OrdersInputServiceImpl(ProductService productService, String fileName) {
        this.productService = productService;
        this.fileName = fileName;
    }

    /**
     * Реализация конвертации строки в заказ
     */
    @Override
    public Order convertStringToObject(String line) throws IOException {
        String[] orderInfos = line.split(";");

        String[] productIds = orderInfos[3].strip().substring(1, orderInfos[3].length() - 1).split(",");
        List<Product> products = Objects.requireNonNull(productService).findProductsByIds(
                Arrays.stream(productIds).map(String::strip).collect(Collectors.toList())
        );

        return new Order(orderInfos[0],
                orderInfos[1],
                LocalDateTime.parse(orderInfos[2], formatter),
                products);
    }
}
