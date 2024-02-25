package com.pract4.service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OutputService {

    private final String path;

    public OutputService(String path){
        this.path = path;
    }

    public <T> void writeFile(List<T> objects){
        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(path))){
            for (T object : objects){
                bufferedWriter.write(object.toString() + "\n");
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
