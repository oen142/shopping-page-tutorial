package com.wani.abeepagetutorial.domain.order.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberId {

    @Column(name = "member_id")
    private String id;

    public MemberId(String id) {
        this.id = id;
    }
}
