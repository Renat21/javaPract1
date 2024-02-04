package com.pract2.service;

import com.pract2.enitites.Order;
import com.pract2.enitites.Product;
import com.pract2.enitites.ResultDTO;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Сервис для работы с заказами
 */
public class OrderService {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.yyyy");

    /**
     * Сервис для чтение заказов из файла
     */
    private final List<Order> orderList;

    public OrderService(List<Order> orderList) {
        this.orderList = orderList;
    }

    /**
     * Метод группирующий все заказы по их дате и формирующий их в список DTO для вывода
     */
    public List<ResultDTO> findOrdersByMonth() {
        return Objects.requireNonNull(orderList).stream()
                .collect(Collectors.groupingBy(order -> order.getDateCreated().format(formatter)))
                .entrySet().stream()
                .collect(ArrayList::new,
                        (list, entry) -> {
                                // Список продуктов за определенный месяц
                                List<Product> value = entry.getValue().stream().flatMap(order -> order.getProducts().stream())
                                    .collect(Collectors.toList());

                                // Формурую DTO для вывода (количество за месяц, месяц, сумма за месяц)
                                list.add(new ResultDTO(value.size(), entry.getKey(), value.stream()
                                        .mapToLong(Product::getCost).sum()));
                            },
                        ArrayList::addAll);
    }
}
