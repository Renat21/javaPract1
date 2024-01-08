package com.pract2.service.impl;

import com.pract2.enitites.Order;
import com.pract2.enitites.Product;
import com.pract2.service.InputService;
import com.pract2.service.ProductService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrdersInputServiceImpl implements InputService<Order> {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    private final ProductService productService;

    private final String fileName;

    public OrdersInputServiceImpl(ProductService productService, String fileName) {
        this.productService = productService;
        this.fileName = fileName;
    }

    @Override
    public List<Order> readDefaultFile() throws IOException {
        return readFile(fileName);
    }

    @Override
    public Order convertStringToObject(String line) throws IOException {
        String[] orderInfos = line.split(";");

        Order order = new Order();
        order.setId(orderInfos[0]);
        order.setUserId(orderInfos[1]);
        order.setDateCreated(LocalDateTime.parse(orderInfos[2], formatter));

        String[] productIds = orderInfos[3].strip().substring(1, orderInfos[3].length() - 1).split(",");
        List<Product> productsList = new ArrayList<>();
        for (String product: productIds){
            productsList.add(productService.findProductById(product.strip()));
        }
        order.setProducts(productsList);

        return order;
    }
}
