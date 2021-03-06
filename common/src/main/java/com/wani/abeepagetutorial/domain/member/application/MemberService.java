package com.wani.abeepagetutorial.domain.member.application;

import com.wani.abeepagetutorial.domain.member.entity.Member;
import com.wani.abeepagetutorial.domain.member.repository.MemberRepository;
import com.wani.abeepagetutorial.domain.member.request.MemberEnrollRequest;
import com.wani.abeepagetutorial.domain.member.response.MemberPageResponse;
import com.wani.abeepagetutorial.domain.member.response.MemberResponse;
import com.wani.abeepagetutorial.domain.member.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberPageResponse findMembers(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Member> members = memberRepository.findAll(pageRequest);
        PageResponse pageResponse = PageResponse.builder()
                .totalPages(members.getTotalPages())
                .isFirstPage(members.isFirst())
                .isLastPage(members.isLast())
                .page(page)
                .size(size)
                .build();
        return MemberPageResponse.builder()
                .page(pageResponse)
                .members(members.stream()
                        .map(MemberResponse::of)
                        .collect(Collectors.toList()))
                .build();
    }

    public MemberResponse findMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                RuntimeException::new);
        return MemberResponse.of(member);
    }

    public MemberResponse enrollMember(MemberEnrollRequest request) {
        Member member = Member.ofMember(request.getUsername(), request.getPassword(), request.getEmail(), request.getPassword());
        memberRepository.save(member);
        return MemberResponse.of(member);
    }

    public MemberResponse enrollAdmin(MemberEnrollRequest request) {
        Member member = Member.ofAdmin(request.getUsername(), request.getPassword(), request.getEmail(), request.getPassword());
        memberRepository.save(member);
        return MemberResponse.of(member);
    }
}
