package com.example.club_server.member.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberDto {
    private Long id;
    private String name;
    private String email;
    private Long clubId;
}
