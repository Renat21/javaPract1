package com.pract1;

import com.pract1.entities.Call;
import com.pract1.services.CallReaderWriter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static CallReaderWriter callReaderWriter;

    private static final Comparator<Call> callComparator =
            Comparator.<Call, LocalDate>comparing(call -> call.getCallTime().toLocalDate())
                    .thenComparing(Call::getCallDuration).reversed();

    public static void main(String[] args) throws IOException {

        callReaderWriter = new CallReaderWriter("logs/", "finalFile/");

        // Получаем список всех звонков
        List<Call> callList = readAllFilesWithLimitAndSort();

        // Записываем результат в файл
        callReaderWriter.writeFile(callList);
    }

    /**
     * Получает список звонков за каждый день отдельно, сортирует данные
     * из каждого файла отдельно, взяв максимум 10 звонков.
     * Потом объединяет и сортирует их снова.
     *
     * @return общий список звонков
     */
    public static List<Call> readAllFilesWithLimitAndSort() throws IOException {
        return callReaderWriter.readAllFiles().stream()
                .flatMap(
                        fileCalls -> fileCalls.stream().sorted(callComparator).limit(10)
                ).sorted(callComparator).collect(Collectors.toList());
    }
}