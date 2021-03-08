package com.wani.abeepagetutorial.controller;

import com.wani.abeepagetutorial.application.MemberService;
import com.wani.abeepagetutorial.request.MemberEnrollRequest;
import com.wani.abeepagetutorial.response.MemberPageResponse;
import com.wani.abeepagetutorial.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;


    @GetMapping("/members")
    public ResponseEntity<MemberPageResponse> findMembers(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        MemberPageResponse response = memberService.findMembers(page, size);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<MemberResponse> findMember(
            @PathVariable("id") Long id
    ) {
        MemberResponse response = memberService.findMember(id);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/members/member")
    public ResponseEntity<MemberResponse> enrollMember(
            @RequestBody MemberEnrollRequest request
    ) {
        MemberResponse response = memberService.enrollMember(request);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/members/admin")
    public ResponseEntity<MemberResponse> enrollAdmin(
            @RequestBody MemberEnrollRequest request
    ) {
        MemberResponse response = memberService.enrollAdmin(request);
        return ResponseEntity.ok().body(response);
    }


}
