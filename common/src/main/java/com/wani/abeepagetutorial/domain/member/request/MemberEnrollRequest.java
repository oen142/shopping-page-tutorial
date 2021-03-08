package com.wani.abeepagetutorial.domain.member.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberEnrollRequest {

    private String username;
    private String email;
    private String password;
    private String phoneNumber;

    public MemberEnrollRequest(String username, String email, String password, String phoneNumber) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
