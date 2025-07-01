package com.example.club_server.club.service;

import com.example.club_server.club.ClubEntity;
import com.example.club_server.club.ClubRepository;
import com.example.club_server.club.model.ClubDto;
import com.example.club_server.club.model.ClubRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClubService {

    private final ClubRepository clubRepository;

    public ClubDto createClub(ClubRequest request) {
        ClubEntity entity = ClubEntity.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();

        return toDto(clubRepository.save(entity));
    }

    public ClubDto getClub(Long id) {
        return toDto(clubRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Club not found: " + id)));
    }

    public List<ClubDto> getAllClubs() {
        return clubRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    public ClubDto updateClub(Long id, ClubRequest request) {
        ClubEntity club = clubRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Club not found: " + id));

        club.setName(request.getName());
        club.setDescription(request.getDescription());

        return toDto(clubRepository.save(club));
    }

    public void deleteClub(Long id) {
        if (!clubRepository.existsById(id)) {
            throw new IllegalArgumentException("Club not found: " + id);
        }
        clubRepository.deleteById(id);
    }

    private ClubDto toDto(ClubEntity entity) {
        return ClubDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}


