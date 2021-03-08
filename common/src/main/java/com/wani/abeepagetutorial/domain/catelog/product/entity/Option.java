package com.wani.abeepagetutorial.domain.catelog.product.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Option {

    @Column(name = "option_value")
    private String value;

    @Column(name = "option_title")
    private String title;

    public Option(String value, String title) {
        this.value = value;
        this.title = title;
    }
}
