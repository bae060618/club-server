package com.example.club_server.club.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClubRequest {

    @NotBlank
    private String name;

    private String description;
}
