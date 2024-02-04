package com.pract2.service.impl;

import com.pract2.enitites.Product;
import com.pract2.service.InputService;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Реализация чтения из файлов для продуктов
 */
public class ProductsInputServiceImpl extends InputService<Product> {

    public ProductsInputServiceImpl(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Реализация конвертации строки в продукт
     */
    public Product convertStringToObject(String line) {
        String[] productInfos = line.split(";");

        return new Product(
                Long.parseLong(productInfos[0]),
                productInfos[1],
                productInfos[2],
                Double.parseDouble(productInfos[3]),
                Long.parseLong(productInfos[4]));
    }

    /**
     * Считываение из файла в отображение по ключу id
     */
    public Map<Long, Product> readFileToMap() {
        return readFileToList().stream()
                .collect(Collectors.toMap(Product::getId, Product::new));
    }
}
