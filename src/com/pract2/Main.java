package com.pract2;

import com.pract2.enitites.ResultDTO;
import com.pract2.service.OrderService;
import com.pract2.service.impl.OrdersInputServiceImpl;
import com.pract2.service.impl.OutputService;
import com.pract2.service.impl.ProductsInputServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){

        // Сервис для чтение продуктов из файла
        ProductsInputServiceImpl productsInputService =
                new ProductsInputServiceImpl("data/pract2/logs/products.csv");

        // Сервис для чтение заказов из файла (передаем все продукты в коснтруктор)
        OrdersInputServiceImpl ordersInputService =
                new OrdersInputServiceImpl(productsInputService.readFileToMap(), "data/pract2/logs/orders.csv");

        // Сервис для работы с заказами (передаем все заказы в конструктор)
        OrderService orderService = new OrderService(ordersInputService.readFileToList());

        // Сервис для записи в файл
        OutputService outputService =
                new OutputService("data/pract2/finalFile/file.csv");

        // Список для вывода результата
        List<ResultDTO> resultDTOList = orderService.findOrdersByMonth();

        // Записываю реултаты в файл
        outputService.writeFile(resultDTOList.stream()
                .map(ResultDTO::toString).collect(Collectors.toList()));
    }
}