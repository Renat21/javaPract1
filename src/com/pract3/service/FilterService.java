package com.pract3.service;


import com.pract3.dto.EmployeeDto;
import com.pract3.service.Predicates.CustomPredicates;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Сервис фильтрации обьектов
 */
public class FilterService {

    /**
     * Спсиок фильтров
     */
    private final List<CustomPredicates<EmployeeDto>> filter;

    @SafeVarargs
    public FilterService(CustomPredicates<EmployeeDto>... predicateList){
        filter = Arrays.stream(predicateList).collect(Collectors.toList());
    }

    /**
     * Метод который для каждого объекта EmployeeDto проверяет все условия из filter
     * и выводит все непрошедшие условия каждого объекта
     */
    public void filterForCheckEmployee(List<EmployeeDto> employeeDtoList) {
        employeeDtoList.forEach(employeeDto -> {
            List<String> errors = filter.stream()
                    .filter(predicate -> !predicate.test(employeeDto))
                    .map(CustomPredicates::getFalseMessage)
                    .collect(Collectors.toList());
            if (!errors.isEmpty()) {
                System.out.println(employeeDto + " : ");
                errors.forEach(System.out::println);
            }
        });
    }

    /**
     * Метод который фильтрует список и возращает новый
     */
    public List<EmployeeDto> filterEmployee(List<EmployeeDto> employeeDtoList){
        return employeeDtoList.stream().filter(
                employeeDto -> filter.stream().allMatch(predicate -> predicate.test(employeeDto))
        ).collect(Collectors.toList());
    }
}
