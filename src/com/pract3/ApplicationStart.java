package com.pract3;


import com.pract3.dto.EmployeeDto;
import com.pract3.service.FilterService;
import com.pract3.service.IOService.InputService;
import com.pract3.service.IOService.OutputService;
import com.pract3.service.IOService.serviceImpl.TxtInputServiceImpl;
import com.pract3.service.IOService.serviceImpl.TxtOutputServiceImpl;
import com.pract3.service.Predicates.checkers.DatePredicate;
import com.pract3.service.Predicates.checkers.ExperiencePredicate;
import com.pract3.service.Predicates.checkers.FullNamePredicate;
import com.pract3.service.Predicates.checkers.SalaryPredicate;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class ApplicationStart {
    public static void main(String[] args) throws IOException {

        // Сервис для чтения обьекта EmployeeDto из txt файла
        InputService<EmployeeDto> inputService = new TxtInputServiceImpl("data/pract2/log/employees.txt");
        // Список всех рабочих
        List<EmployeeDto> employeeDtoList = inputService.readFile();

        // Фильтры для реализации задачи 1 : проверятся данные на соответствие 3 правилам
        FilterService filter1 = new FilterService(new DatePredicate(), new FullNamePredicate(),
                new SalaryPredicate());
        // Проверка нашего спсика рабочих на вышеуказанных фильтрах
        filter1.filterForCheckEmployee(employeeDtoList);


        // Фильтр с 1 улсовием на проверку опыта рабочих
        FilterService filter2 = new FilterService(new ExperiencePredicate());
        // Фильтруем и потом сортируем обьекты по их опыту
        List<EmployeeDto> list = filter2.filterEmployee(employeeDtoList).stream().sorted(
                Comparator.comparing(EmployeeDto::getLocalDate)).toList();

        // Сервис для записи обьекта EmployeeDto в txt файл
        OutputService<EmployeeDto> outputService = new TxtOutputServiceImpl("data/pract2/finalFile/result.txt");
        outputService.writeFile(list);
    }
}