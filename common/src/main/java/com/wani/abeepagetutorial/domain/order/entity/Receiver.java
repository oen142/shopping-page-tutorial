package com.wani.abeepagetutorial.domain.order.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@Getter
public class Receiver {

    @Column(name = "receiver_name")
    private String name;
    @Column(name = "receiver_phone")
    private String phone;

    public Receiver(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
