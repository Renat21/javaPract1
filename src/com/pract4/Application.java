package com.pract4;

import com.pract4.service.impl.TeaBrewingInputService;
import com.pract4.service.impl.TeaInputService;
import com.pract4.service.impl.TeaTypeInputService;
import com.pract4.service.OutputService;
import com.pract4.service.StatisticService;

public class Application {
    public static void main(String[] args) {
        TeaTypeInputService teaTypeInputService = new TeaTypeInputService("data/pract4/tea_type.csv");
        TeaInputService teaInputService =
                new TeaInputService("data/pract4/tea.csv", teaTypeInputService.readFileToMap());
        TeaBrewingInputService teaBrewingInputService =
                new TeaBrewingInputService("data/pract4/tea_brewing.csv", teaInputService.readFileToMap());

        StatisticService statisticService = new StatisticService(teaBrewingInputService.readFile());

        OutputService outputService = new OutputService("data/pract4/output.csv");
        outputService.writeFile(statisticService.getStatisticFromTeaBrewing());
    }
}
