package com.pract2.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public interface InputService<T> {

    default List<T> readFile(String inputDirectoryFile) throws IOException {
        List<T> productList = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(inputDirectoryFile))) {

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

    T convertStringToObject(String line) throws IOException;

    List<T> readDefaultFile() throws IOException;
}
