package com.pract3.service.Predicates.checkers;

import com.pract3.dto.EmployeeDto;
import com.pract3.service.Predicates.CustomPredicates;
import java.time.LocalDate;

/**
 * Класс проверки объектов EmployeeDto на дату
 */
public class DatePredicate extends CustomPredicates<EmployeeDto> {

    public static final String falseMessage =  "Поле даты не прошло проверку";

    public DatePredicate() {
        super(falseMessage);
    }

    @Override
    public boolean test(EmployeeDto employeeDto) {
        return LocalDate.now().isAfter(employeeDto.getLocalDate());
    }
}
