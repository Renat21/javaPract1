package com.pract4.service.impl;

import com.pract4.service.InputService;
import com.pract4.entity.TeaType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TeaTypeInputService extends InputService<TeaType> {

    public TeaTypeInputService(String path){
        this.path = path;
    }

    public Map<Long, TeaType> readFileToMap(){
        List<TeaType> teaTypes = readFile();
        return teaTypes.stream().collect(Collectors.toMap(TeaType::id,
                teaType -> teaType));
    }

    @Override
    public TeaType stringToObject(String line) {
        String[] data = line.split(";");

        return new TeaType(Long.parseLong(data[0]),
                data[1],
                Integer.parseInt(data[2]),
                Integer.parseInt(data[3]),
                Integer.parseInt(data[4]),
                Integer.parseInt(data[5]));
    }
}
