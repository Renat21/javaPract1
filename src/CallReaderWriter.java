import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
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

    CallReaderWriter(String inputDirectory, String outputDirectory) {
        this.inputDirectory = inputDirectory;
        this.outputDirectory = outputDirectory;
    }

    /**
     * Считывает все файлы и возвращает список звонков за каждый день
     *
     * @return список звонков за каждый день
     */
    public List<List<Call>> readAllFiles() {
        File directory = new File(inputDirectory);
        return Arrays.stream(Objects.requireNonNull(directory.listFiles()))
                .map(fileName -> readFile(fileName.getName()))
                .collect(Collectors.toList());
    }

    /**
     * Считывает из файла звонки
     *
     * @param fileName название файла звонков
     * @return список звонков
     */
    public List<Call> readFile(String fileName) {
        List<Call> calls = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputDirectory + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                calls.add(Call.parseString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return calls;
    }

    /**
     * Записывает в файл список звонков
     *
     * @param callList список звонков
     */
    public void writeFile(List<Call> callList) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(outputDirectory + "final.txt"))) {
            bufferedWriter.write(
                    callList.stream()
                            .map(Call::toString)
                            .collect(Collectors.joining())
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
