package com.pract3.service.IOService;

import java.io.IOException;
import java.util.List;

/**
 * Абстрактный класс для реализации записи в файл
 */
public abstract class OutputService<T> {

    /**
     * Путь к файлу вывода
     */
    protected String outputDirectory;

    /**
     * Реализация записи в файл из списка
     */
    abstract public void writeFile(List<T> list) throws IOException;
}