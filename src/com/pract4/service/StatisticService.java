package com.pract4.service;

import com.pract4.entity.OutputDto;
import com.pract4.entity.TeaBrewing;
import com.pract4.entity.TeaType;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class StatisticService {

    private final List<TeaBrewing> teaBrewingList;

    public StatisticService(List<TeaBrewing> teaBrewingList) {
        this.teaBrewingList = teaBrewingList;
    }

    public List<OutputDto> getStatisticFromTeaBrewing(){
        List<OutputDto> outputDto = new ArrayList<>();
        Map<LocalDate, List<TeaBrewing>> teaBrewingByDay =
                teaBrewingList.stream().collect(Collectors.groupingBy(
                        teaBrewing -> teaBrewing.getFrom().toLocalDate()));

        teaBrewingByDay.forEach((day, dayTeas) -> {
            Set<String> employees = dayTeas.stream().map(TeaBrewing::getName).collect(Collectors.toSet());

            dayTeas.forEach(teaBrewing -> {
                final long brewingTime = ChronoUnit.SECONDS.between(teaBrewing.getFrom(), teaBrewing.getTo());
                final TeaType teaType = teaBrewing.getTea().getTeaType();

                if (!(teaType.getTimeTo() >= brewingTime && brewingTime >= teaType.getTimeFrom() &&
                        teaType.getTempTo() >= teaBrewing.getTemp() && teaBrewing.getTemp() >= teaType.getTempFrom())){
                    employees.remove(teaBrewing.getName());
                }
            });
            if (!employees.isEmpty()) {
                outputDto.add(new OutputDto(day, employees));
            }
        });

        return outputDto;
    }
}
