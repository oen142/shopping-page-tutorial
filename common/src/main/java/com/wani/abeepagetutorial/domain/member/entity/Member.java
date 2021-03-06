package com.wani.abeepagetutorial.domain.member.entity;

import com.wani.abeepagetutorial.domain.common.entity.AbstractEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends AbstractEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String username;
    private String password;
    private String email;
    private String phoneNumber;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<MemberAuthority> memberAuthorities = new HashSet<>();

    @Builder
    private Member(String username, String password, String email, String phoneNumber, Set<MemberAuthority> memberAuthorities) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.memberAuthorities = memberAuthorities;
    }

    public static Member ofMember(String username, String password, String email, String phoneNumber) {
        Set<MemberAuthority> memberAuthorities = new HashSet<>();
        memberAuthorities.add(MemberAuthority.ofMember());
        return Member.builder()
                .username(username)
                .password(password)
                .email(email)
                .phoneNumber(phoneNumber)
                .memberAuthorities(memberAuthorities)
                .build();
    }

    public static Member ofAdmin(String username, String password, String email, String phoneNumber) {
        Set<MemberAuthority> memberAuthorities = new HashSet<>();
        memberAuthorities.add(MemberAuthority.ofAdmin());
        return Member.builder()
                .username(username)
                .password(password)
                .email(email)
                .phoneNumber(phoneNumber)
                .memberAuthorities(memberAuthorities)
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
