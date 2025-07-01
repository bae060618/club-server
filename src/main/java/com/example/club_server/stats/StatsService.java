package com.example.club_server.stats;

import com.example.club_server.club.ClubRepository;
import com.example.club_server.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatsService {

    private final ClubRepository clubRepository;
    private final MemberRepository memberRepository;

    public StatsResponse getStatistics() {
        long clubCount = clubRepository.count();
        long memberCount = memberRepository.count();

        return StatsResponse.builder()
                .totalClubs(clubCount)
                .totalMembers(memberCount)
                .build();
    }
}

