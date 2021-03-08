package com.wani.abeepagetutorial.response;

import com.wani.abeepagetutorial.domain.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberResponse {

    private String username;
    private String email;
    private String phoneNumber;


    @Builder
    private MemberResponse(String username, String email, String phoneNumber) {
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public static MemberResponse of(Member member) {
        return MemberResponse.builder()
                .username(member.getUsername())
                .email(member.getEmail())
                .phoneNumber(member.getPhoneNumber())
                .build();
    }
}
