package com.pract3.service.Predicates.checkers;


import com.pract3.dto.EmployeeDto;
import com.pract3.service.Predicates.CustomPredicates;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


/**
 * Класс проверки объектов EmployeeDto на опыт
 */
public class ExperiencePredicate extends CustomPredicates<EmployeeDto> {

    public static final String falseMessage =  "Опыта меньше 3 месяцев";

    public ExperiencePredicate() {
        super(falseMessage);
    }

    @Override
    public boolean test(EmployeeDto employeeDto) {
        return ChronoUnit.MONTHS.between(employeeDto.getLocalDate(), LocalDate.now()) > 3;
    }

}
