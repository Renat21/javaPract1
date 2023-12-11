import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис для работы с сущностью звонка
 */
public class CallService {
    /**
     * Объект для работы с файлами
     */
    private CallReaderWriter callReaderWriter;

    /**
     * Запускает приложение
     */
    public void startApplication() {
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
    public List<Call> readAllFilesWithLimitAndSort() {
        return callReaderWriter.readAllFiles().stream()
                .flatMap(
                        fileCalls -> fileCalls.stream().sorted().limit(10)
                ).sorted().collect(Collectors.toList());
    }
}
