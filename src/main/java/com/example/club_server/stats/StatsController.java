package com.example.club_server.stats;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stats")
@RequiredArgsConstructor
public class StatsController {

    private final StatsService statsService;

    @GetMapping("")
    public StatsResponse getStats() {
        return statsService.getStatistics();
    }
}

