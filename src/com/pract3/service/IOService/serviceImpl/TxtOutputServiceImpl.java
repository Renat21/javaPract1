package com.pract3.service.IOService.serviceImpl;

import com.pract3.dto.EmployeeDto;
import com.pract3.service.IOService.OutputService;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Класс запсии в файл txt
 */
public class TxtOutputServiceImpl extends OutputService<EmployeeDto> {

    public TxtOutputServiceImpl(String outputDirectory){
        super.outputDirectory = outputDirectory;
    }

    /**
     * Реализация записи в файл txt из списка
     */
    public void writeFile(List<EmployeeDto> employeeDtoList) throws IOException {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(outputDirectory))) {
            for (EmployeeDto employeeDto: employeeDtoList){
                bufferedWriter.write(
                        employeeDto.getFullName() + ":"
                                + ChronoUnit.MONTHS.between(employeeDto.getLocalDate(), LocalDate.now()) + ":"
                                + employeeDto.getSalary() + "\n");
            }
        } catch (IOException e) {
            throw e;
        }
    }
}
