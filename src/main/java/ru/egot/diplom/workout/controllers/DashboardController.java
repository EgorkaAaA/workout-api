package ru.egot.diplom.workout.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.egot.diplom.workout.dto.statistic.Dashboard;
import ru.egot.diplom.workout.services.DashboardService;

import java.util.List;

@RestController
@RequestMapping("/public/dashboard")
@RequiredArgsConstructor
@Slf4j
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping()
    public ResponseEntity<List<Dashboard>> getGraph() {
        log.info("GetRequest");
        List<Dashboard> dashboardStatistic = dashboardService.getDashboardStatistic();
        log.info("Answer: {}", dashboardStatistic);
        return ResponseEntity.ok(dashboardStatistic);
    }

}
