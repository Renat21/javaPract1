package com.pract3.service.IOService;

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
    abstract public List<T> readFile() throws IOException;

    /**
     * Метод конвертирующий строку в определенный обьект
     */
    abstract public T convertStringToObject(String line);
}