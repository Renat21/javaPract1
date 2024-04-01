package com.pract4.service.impl;

import com.pract4.service.InputService;
import com.pract4.entity.Tea;
import com.pract4.entity.TeaType;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TeaInputService extends InputService<Tea> {

    private final Map<Long, TeaType> teaTypes;

    public TeaInputService(String path, Map<Long, TeaType> teaTypes){
        this.path = path;
        this.teaTypes = teaTypes;
    }

    public Map<Long, Tea> readFileToMap(){
        List<Tea> teaList = readFile();
        return teaList.stream().collect(Collectors.toMap(Tea::id,
                Function.identity()));
    }

    @Override
    public Tea stringToObject(String line) {
        String[] data = line.split(";");

        return new Tea(Long.parseLong(data[0]),
                data[1],
                teaTypes.get(Long.parseLong(data[2])));
    }
}
