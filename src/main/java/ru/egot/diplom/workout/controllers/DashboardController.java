package ru.egot.diplom.workout.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.egot.diplom.workout.dto.statistic.Dashboard;
import ru.egot.diplom.workout.services.DashboardService;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping()
    public List<Dashboard> getGraph() {
        return dashboardService.getDashboardStatistic();
    }

}