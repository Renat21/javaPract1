import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


/**
 * Сущность звонка из колл-центра
 */
public class Call implements Comparable<Call> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Дата и время начала звонка
     */
    private LocalDateTime callTime;

    /**
     * длительность звонка
     */
    private Duration callDuration;

    private void setCallTime(LocalDateTime callTime) {
        this.callTime = callTime;
    }

    private void setCallDuration(Duration callDuration) {
        this.callDuration = callDuration;
    }

    public LocalDateTime getCallTime() {
        return this.callTime;
    }

    public Duration getCallDuration() {
        return this.callDuration;
    }

    /**
     * Преобразует из строки объект звонка
     *
     * @param callPosixTime строка содержащая в себе даты начала и конца одного звонка через запятую
     * @return сущность звонка
     */
    public static Call parseString(String callPosixTime) {
        Call call = new Call();
        String[] callInfo = callPosixTime.split(",");
        LocalDateTime callStartTime = LocalDateTime.ofInstant(
                Instant.ofEpochSecond(Long.parseLong(callInfo[0])),
                ZoneId.systemDefault());
        LocalDateTime callEndTime = LocalDateTime.ofInstant(
                Instant.ofEpochSecond(Long.parseLong(callInfo[1])),
                ZoneId.systemDefault());
        call.setCallTime(callStartTime);
        call.setCallDuration(Duration.between(callStartTime, callEndTime));
        return call;
    }

    /**
     * Сперва происходит сравнение по дате начала звонка,
     * а потом сравниваются длительности звонков
     */
    @Override
    public int compareTo(Call call) {
        if (!callTime.toLocalDate().isEqual(call.getCallTime().toLocalDate()))
            return call.getCallTime().compareTo(callTime);
        return call.getCallDuration().compareTo(callDuration);
    }

    @Override
    public String toString() {
        return callTime.format(formatter)
                + " - "
                + String.format("%d ч %02d мин %02d с",
                callDuration.toHours(),
                callDuration.toMinutesPart(),
                callDuration.toSecondsPart())
                + "\n";
    }
}
