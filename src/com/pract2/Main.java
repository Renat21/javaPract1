package com.pract2;

import com.pract2.service.OrderService;
import com.pract2.service.ProductService;
import com.pract2.service.impl.OrdersInputServiceImpl;
import com.pract2.service.impl.OutputService;
import com.pract2.service.impl.ProductsInputServiceImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ProductService productService = new ProductService(
                new ProductsInputServiceImpl("data/pract2/logs/products.csv"));
        OrderService orderService = new OrderService(
                new OrdersInputServiceImpl(productService, "data/pract2/logs/orders.csv"),
                new OutputService("data/pract2/finalFile/file.csv"));

        orderService.createAndSaveResultToFile();
    }
}