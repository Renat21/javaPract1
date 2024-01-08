package com.pract2.service;

import com.pract2.enitites.Product;
import com.pract2.service.impl.OrdersInputServiceImpl;
import com.pract2.service.impl.OutputService;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class OrderService {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.yyyy");

    private final OrdersInputServiceImpl ordersInputService;

    private final OutputService outputService;

    public OrderService(OrdersInputServiceImpl ordersInputService, OutputService outputService) {
        this.ordersInputService = ordersInputService;
        this.outputService = outputService;
    }

    public Map<String, List<Product>> findOrdersByMonth() throws IOException {
        return Objects.requireNonNull(ordersInputService).readDefaultFile().stream()
                .collect(Collectors.groupingBy(order -> order.getDateCreated().format(formatter)))
                .entrySet().stream()
                .collect(HashMap::new,
                        (map, entry) -> map.put(entry.getKey(),
                                entry.getValue().stream().flatMap(order -> order.getProducts().stream())
                                        .collect(Collectors.toList())),
                        HashMap::putAll);
    }

    public void createAndSaveResultToFile() throws IOException {
        Map<String, List<Product>> ordersPerMonth = findOrdersByMonth();
        List<String> resultLine = ordersPerMonth.entrySet().stream()
                .map(entry ->
                        entry.getKey()
                                + " " + entry.getValue().size()
                                + " " + entry.getValue().stream().mapToLong(Product::getCost).sum()
                ).collect(Collectors.toList());

        Objects.requireNonNull(outputService).writeFile(resultLine);
    }
}
