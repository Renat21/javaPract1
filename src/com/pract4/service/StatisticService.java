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
                        teaBrewing -> teaBrewing.from().toLocalDate()));

        teaBrewingByDay.forEach((day, dayTeas) -> {
            Set<String> employees = dayTeas.stream().map(TeaBrewing::name).collect(Collectors.toSet());

            dayTeas.forEach(teaBrewing -> {
                final long brewingTime = ChronoUnit.SECONDS.between(teaBrewing.from(), teaBrewing.to());
                final TeaType teaType = teaBrewing.tea().teaType();

                if (!(teaType.timeTo() >= brewingTime && brewingTime >= teaType.timeFrom() &&
                        teaType.tempTo() >= teaBrewing.temp() && teaBrewing.temp() >= teaType.tempFrom())){
                    employees.remove(teaBrewing.name());
                }
            });

            outputDto.add(new OutputDto(day, employees));
        });

        return outputDto;
    }
}
