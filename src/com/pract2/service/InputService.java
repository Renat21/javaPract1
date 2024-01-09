package com.pract2.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
 * Абстрактный класс для реализации чтения из файлов
 */
public abstract class InputService<T> {

    /**
     * Путь к файлу с его именем
     */
    protected String fileName;

    /**
     * Реализация чтения из файлов превращая все в список определенных сущностей
     */
    public List<T> readFile() throws IOException {
        List<T> productList = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(fileName))) {

            // Первая строка просто для информации
            bufferedReader.readLine();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                productList.add(convertStringToObject(line));
            }
        } catch (IOException e) {
            System.out.println("File reading problems: " + e.getMessage());
            throw e;
        }
        return productList;
    }

    /**
     * Метод конверирующий строку в определенный обьект
     */
    public T convertStringToObject(String line) throws IOException {
        return null;
    }
}
