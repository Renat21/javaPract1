package com.pract3.service.IOService.serviceImpl;

import com.pract3.dto.EmployeeDto;
import com.pract3.service.IOService.InputService;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/**
 * Класс чтения из файла txt
 */
public class TxtInputServiceImpl extends InputService<EmployeeDto> {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public TxtInputServiceImpl(String filename){
        super.fileName = filename;
    }

    /**
     * Считывает данные из файла и преобразует их в список обьектов EmployeeDto
     */
    @Override
    public List<EmployeeDto> readFile() throws IOException {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        try(BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(fileName))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                employeeDtoList.add(convertStringToObject(line));
            }
        }catch (IOException e){
            throw e;
        }
        return employeeDtoList;
    }

    /**
     * Превращает строкув обьект EmployeeDto
     */
    @Override
    public EmployeeDto convertStringToObject(String employeeLine){
        String[] employeeInfo = employeeLine.split(";");
        return new EmployeeDto(
                employeeInfo[0],
                LocalDate.parse(employeeInfo[1], formatter),
                Long.parseLong(employeeInfo[2])
        );
    }
}
