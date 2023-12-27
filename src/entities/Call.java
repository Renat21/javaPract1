package entities;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


/**
 * Сущность звонка из колл-центра
 */
public final class Call{

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");

    /**
     * Дата и время начала звонка
     */
    private final LocalDateTime callTime;

    /**
     * длительность звонка
     */
    private final Duration callDuration;

    /**
     * Преобразует из строки объект звонка
     *
     * @param callPosixTime строка содержащая в себе даты начала и конца одного звонка через запятую
     */
    public Call(String callPosixTime) {
        String[] callInfo = callPosixTime.split(",");
        LocalDateTime callStartTime;
        LocalDateTime callEndTime;
        
        try {
            callStartTime = LocalDateTime.ofInstant(
                    Instant.ofEpochSecond(Long.parseLong(callInfo[0])),
                    ZoneId.systemDefault());
            callEndTime = LocalDateTime.ofInstant(
                    Instant.ofEpochSecond(Long.parseLong(callInfo[1])),
                    ZoneId.systemDefault());
        } catch (DateTimeParseException e) {
            System.out.println("Ошибка парсинга даты и времени: " + e.getMessage());
            throw e;
        }

        this.callTime = callStartTime;
        this.callDuration = Duration.between(callStartTime, callEndTime);
    }

    public LocalDateTime getCallTime() {
        return this.callTime;
    }

    public Duration getCallDuration() {
        return this.callDuration;
    }

    @Override
    public String toString() {
        return callTime.format(formatter)
                + " - "
                + String.format("%d ч %02d мин %02d с",
                callDuration.toHours(),
                callDuration.toMinutesPart(),
                callDuration.toSecondsPart());
    }
}
