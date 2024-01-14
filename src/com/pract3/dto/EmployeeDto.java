package com.pract3.dto;

import java.time.LocalDate;

/**
 * Модель сотрудника
 */
public class EmployeeDto {

    private final String fullName;
    private final LocalDate localDate;
    private final Long salary;

    public EmployeeDto(String fullName, LocalDate localDate, Long salary){
        this.fullName = fullName;
        this.localDate = localDate;
        this.salary = salary;
    }
    public LocalDate getLocalDate() {
        return localDate;
    }

    public Long getSalary() {
        return salary;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "fullName=" + fullName +
                ", localDate=" + localDate +
                ", salary=" + salary +
                '}';
    }
}
