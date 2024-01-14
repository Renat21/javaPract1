package com.pract3.service.Predicates.checkers;

import com.pract3.dto.EmployeeDto;
import com.pract3.service.Predicates.CustomPredicates;

/**
 * Класс проверки объектов EmployeeDto поле оклада
 */
public class SalaryPredicate extends CustomPredicates<EmployeeDto> {

    public static final String falseMessage =  "Поле оклада не кратно 100";

    public SalaryPredicate() {
        super(falseMessage);
    }

    @Override
    public boolean test(EmployeeDto employeeDto) {
        return employeeDto.getSalary() % 100 == 0;
    }
}
