package com.example.club_server.club.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ClubDto {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
}
