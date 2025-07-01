package com.example.club_server.member.service;

import com.example.club_server.club.ClubEntity;
import com.example.club_server.club.ClubRepository;
import com.example.club_server.member.MemberEntity;
import com.example.club_server.member.MemberRepository;
import com.example.club_server.member.model.MemberDto;
import com.example.club_server.member.model.MemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final ClubRepository clubRepository;

    public MemberDto createMember(Long clubId, MemberRequest request) {
        ClubEntity club = clubRepository.findById(clubId)
                .orElseThrow(() -> new IllegalArgumentException("Club not found: " + clubId));

        MemberEntity entity = MemberEntity.builder()
                .name(request.getName())
                .email(request.getEmail())
                .club(club)
                .build();

        return toDto(memberRepository.save(entity));
    }

    public List<MemberDto> getMembersByClub(Long clubId) {
        ClubEntity club = clubRepository.findById(clubId)
                .orElseThrow(() -> new IllegalArgumentException("Club not found: " + clubId));

        return club.getMembers().stream()
                .map(this::toDto)
                .toList();
    }

    public MemberDto updateMember(Long memberId, MemberRequest request) {
        MemberEntity member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found: " + memberId));

        member.setName(request.getName());
        member.setEmail(request.getEmail());

        return toDto(memberRepository.save(member));
    }

    public void deleteMember(Long memberId) {
        if (!memberRepository.existsById(memberId)) {
            throw new IllegalArgumentException("Member not found: " + memberId);
        }
        memberRepository.deleteById(memberId);
    }

    private MemberDto toDto(MemberEntity entity) {
        return MemberDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .clubId(entity.getClub().getId())
                .build();
    }
}
