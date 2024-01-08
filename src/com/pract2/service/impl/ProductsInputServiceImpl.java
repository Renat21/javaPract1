package com.pract2.service.impl;

import com.pract2.enitites.Product;
import com.pract2.service.InputService;

import java.io.IOException;
import java.util.List;

public class ProductsInputServiceImpl implements InputService<Product> {

    private final String fileName;

    public ProductsInputServiceImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Product> readDefaultFile() throws IOException {
        return readFile(fileName);
    }

    public Product convertStringToObject(String line) {
        String[] productInfos = line.split(";");

        Product product = new Product();
        product.setId(productInfos[0]);
        product.setName(productInfos[1]);
        product.setDescription(productInfos[2]);
        product.setWeight(Double.parseDouble(productInfos[3]));
        product.setCost(Long.parseLong(productInfos[4]));
        return product;
    }
}
