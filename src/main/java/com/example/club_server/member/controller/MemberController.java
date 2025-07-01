package com.example.club_server.member.controller;

import com.example.club_server.member.model.MemberDto;
import com.example.club_server.member.model.MemberRequest;
import com.example.club_server.member.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/club/{clubId}")
    public MemberDto create(
            @PathVariable Long clubId,
            @Valid @RequestBody MemberRequest request
    ) {
        MemberDto result = memberService.createMember(clubId, request);
        log.info("Member Created: {}", result);
        return result;
    }

    @GetMapping("/club/{clubId}")
    public List<MemberDto> getByClub(@PathVariable Long clubId) {
        List<MemberDto> members = memberService.getMembersByClub(clubId);
        log.info("Club {} has {} members", clubId, members.size());
        return members;
    }

    @PutMapping("/{id}")
    public MemberDto update(
            @PathVariable Long id,
            @Valid @RequestBody MemberRequest request
    ) {
        MemberDto updated = memberService.updateMember(id, request);
        log.info("Member Updated: {}", updated);
        return updated;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        memberService.deleteMember(id);
        log.info("Member Deleted: {}", id);
    }
}
