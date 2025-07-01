package com.example.club_server.club.controller;

import com.example.club_server.club.model.ClubDto;
import com.example.club_server.club.model.ClubRequest;
import com.example.club_server.club.service.ClubService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clubs")
@RequiredArgsConstructor
public class ClubController {

    private final ClubService clubService;

    @PostMapping("")
    public ClubDto create(@Valid @RequestBody ClubRequest request) {
        ClubDto result = clubService.createClub(request);
        log.info("Club Created: {}", result);
        return result;
    }

    @GetMapping("/{id}")
    public ClubDto get(@PathVariable Long id) {
        return clubService.getClub(id);
    }

    @GetMapping("")
    public List<ClubDto> list() {
        return clubService.getAllClubs();
    }

    @PutMapping("/{id}")
    public ClubDto update(@PathVariable Long id, @Valid @RequestBody ClubRequest request) {
        return clubService.updateClub(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clubService.deleteClub(id);
    }
}


