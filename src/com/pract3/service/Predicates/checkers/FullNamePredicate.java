package com.pract3.service.Predicates.checkers;

import com.pract3.dto.EmployeeDto;
import com.pract3.service.Predicates.CustomPredicates;

/**
 * Класс проверки объектов EmployeeDto поле имени
 */
public class FullNamePredicate extends CustomPredicates<EmployeeDto> {

    public static final String falseMessage =  "Поле имени больше 120 символов";

    public FullNamePredicate() {
        super(falseMessage);
    }

    @Override
    public boolean test(EmployeeDto employeeDto) {
        return employeeDto.getFullName().length() <= 120;
    }
}
