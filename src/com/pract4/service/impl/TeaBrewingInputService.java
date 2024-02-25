package com.pract4.service.impl;

import com.pract4.service.InputService;
import com.pract4.entity.Tea;
import com.pract4.entity.TeaBrewing;

import java.time.LocalDateTime;
import java.util.Map;

public class TeaBrewingInputService extends InputService<TeaBrewing> {

    private final Map<Long, Tea> teaMap;

    public TeaBrewingInputService(String path, Map<Long, Tea> teaMap){
        this.path = path;
        this.teaMap = teaMap;
    }

    @Override
    public TeaBrewing stringToObject(String line) {
        String[] data = line.split(";");

        return new TeaBrewing(data[0],
                teaMap.get(Long.parseLong(data[1])),
                LocalDateTime.parse(data[2]),
                LocalDateTime.parse(data[3]),
                Integer.parseInt(data[4]));
    }
}