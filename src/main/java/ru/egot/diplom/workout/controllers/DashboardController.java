package ru.egot.diplom.workout.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.egot.diplom.workout.dto.statistic.Dashboard;
import ru.egot.diplom.workout.services.DashboardService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/public/dashboard")
@RequiredArgsConstructor
@Slf4j
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping
    @CrossOrigin
    public ResponseEntity<List<Dashboard>> getGraph(@RequestParam String username, @RequestParam LocalDate start, @RequestParam LocalDate finish) {
        List<Dashboard> dashboardStatistic = dashboardService.getDashboardStatistic(username, start, finish);
        return ResponseEntity.ok(dashboardStatistic);
    }

}
