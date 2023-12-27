package services;

import entities.Call;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * Сервис работы с записью/чтением из файла
 */
public class CallReaderWriter {

    /**
     * Название дериктории с звонками
     */
    private final String inputDirectory;

    /**
     * Название дериктории, куда нужно вывести обработанные данные
     */
    private final String outputDirectory;

    public CallReaderWriter(String inputDirectory, String outputDirectory) {
        this.inputDirectory = inputDirectory;
        this.outputDirectory = outputDirectory;
    }

    /**
     * Считывает все файлы и возвращает список звонков за каждый день
     *
     * @return список звонков за каждый день
     */
    public List<List<Call>> readAllFiles() throws IOException {
        File directory = new File(inputDirectory);
        List<List<Call>> callList = new ArrayList<>();

        for (File file : Objects.requireNonNull(directory.listFiles())){
            callList.add(readFile(file.getName()));
        }

        return callList;
    }

    /**
     * Считывает из файла звонки
     *
     * @param fileName название файла звонков
     * @return список звонков
     */
    public List<Call> readFile(String fileName) throws IOException {
        List<Call> calls = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputDirectory + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                calls.add(new Call(line));
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: " + e.getMessage());
            throw e;
        }
        return calls;
    }

    /**
     * Записывает в файл список звонков
     *
     * @param callList список звонков
     */
    public void writeFile(List<Call> callList) throws IOException {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(outputDirectory + "final.txt"))) {
            bufferedWriter.write(
                    callList.stream()
                            .map(Call::toString)
                            .collect(Collectors.joining("\n"))
            );
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: " + e.getMessage());
            throw e;
        }
    }
}
