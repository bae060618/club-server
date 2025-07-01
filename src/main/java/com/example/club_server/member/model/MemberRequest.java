package com.example.club_server.member.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberRequest {

    @NotBlank
    private String name;

    @Email
    private String email;
}
