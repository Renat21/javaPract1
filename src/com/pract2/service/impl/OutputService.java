package com.pract2.service.impl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OutputService {

    private final String outputDirectoryFile;

    public OutputService(String outputDirectoryFile) {
        this.outputDirectoryFile = outputDirectoryFile;
    }

    public void writeFile(List<String> outputInfo) throws IOException {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(outputDirectoryFile))) {
            for(String out: outputInfo){
                bufferedWriter.write(out + "\n");
            }
        } catch (IOException e) {
            System.out.println("Output problems : " + e.getMessage());
            throw e;
        }
    }
}