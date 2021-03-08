package com.wani.abeepagetutorial.domain.member.entity;


import com.wani.abeepagetutorial.domain.common.entity.AbstractEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberAuthority extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_authority_id")
    private Long id;

    @Enumerated
    private Authority authority;


    @Builder
    private MemberAuthority(Authority authority) {
        this.authority = authority;
    }

    public static MemberAuthority ofMember() {
        return MemberAuthority.builder()
                .authority(Authority.NORMAL)
                .build();
    }

    public static MemberAuthority ofAdmin() {
        return MemberAuthority.builder()
                .authority(Authority.ADMIN)
                .build();
    }
}
