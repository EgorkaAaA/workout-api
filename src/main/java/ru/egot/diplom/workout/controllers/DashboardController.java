package ru.egot.diplom.workout.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.egot.diplom.workout.dto.statistic.Dashboard;
import ru.egot.diplom.workout.dto.statistic.DashboardDataDto;
import ru.egot.diplom.workout.services.DashboardService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/public/dashboard")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping
    public ResponseEntity<List<Dashboard>> getGraph(@RequestParam String username, @RequestParam LocalDate start, @RequestParam LocalDate finish) {
        return ResponseEntity.ok(dashboardService.getDashboardStatistic(username, start, finish));
    }

    @PostMapping
    public ResponseEntity<Dashboard> setGraph(@RequestBody DashboardDataDto dataDto) {
        return ResponseEntity.ok(dashboardService.setDashboardStatistic(dataDto));
    }

}
