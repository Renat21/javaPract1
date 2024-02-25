package com.pract4.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

abstract public class InputService<T> {

    protected String path;

    public List<T> readFile(){
        List<T> data = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(path))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                data.add(stringToObject(line));
            }
        }catch (IOException e){
            throw new UncheckedIOException(e);
        }

        return data;
    };

    abstract public T stringToObject(String line);

}
