package com.pract2.service.impl;

import com.pract2.enitites.Order;
import com.pract2.enitites.Product;
import com.pract2.service.InputService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Реализация чтения из файлов пдля заказов
 */
public class OrdersInputServiceImpl extends InputService<Order> {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    private final Map<Long, Product> productMap;

    public OrdersInputServiceImpl(Map<Long, Product> productMap, String fileName) {
        this.productMap = productMap;
        this.fileName = fileName;
    }

    /**
     * Реализация конвертации строки в заказ
     */
    @Override
    public Order convertStringToObject(String line){
        String[] orderInfos = line.split(";");

        String[] productIds = orderInfos[3].strip().substring(1, orderInfos[3].length() - 1).split(",");
        List<Product> products =
                Arrays.stream(productIds).map(productId -> productMap.get(Long.parseLong(productId.strip())))
                        .collect(Collectors.toList());

        return new Order(Long.parseLong(orderInfos[0]),
                orderInfos[1],
                LocalDateTime.parse(orderInfos[2], formatter),
                products);
    }
}
