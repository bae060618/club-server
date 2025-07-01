package com.example.club_server.stats;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StatsResponse {
    private long totalClubs;
    private long totalMembers;
}

