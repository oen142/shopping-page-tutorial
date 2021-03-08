package com.wani.abeepagetutorial.domain.member.entity;


import com.wani.abeepagetutorial.domain.common.AbstractEntity;

import javax.persistence.*;

@Entity
public class MemberAuthority extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_authority_id")
    private Long id;

    @Enumerated
    private Authority authority;


}
