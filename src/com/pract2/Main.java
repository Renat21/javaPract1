package com.pract2;

import com.pract2.service.OrderService;
import com.pract2.service.ProductService;
import com.pract2.service.impl.OrdersInputServiceImpl;
import com.pract2.service.impl.OutputService;
import com.pract2.service.impl.ProductsInputServiceImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Сервис для работы с продуктами
        ProductService productService = new ProductService(
                // Сервис для чтение продуктов из файла
                new ProductsInputServiceImpl("data/pract2/logs/products.csv"));

        // Сервис для работы с заказами
        OrderService orderService = new OrderService(
                // Сервис для чтение заказов из файла
                new OrdersInputServiceImpl(productService, "data/pract2/logs/orders.csv"),
                // Сервис для записи в файл
                new OutputService("data/pract2/finalFile/file.csv"));

        orderService.createAndSaveResultToFile();
    }
}