package com.wani.abeepagetutorial.domain.order.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class OrderNo {

    @Column(name = "order_number")
    private String number;

    public OrderNo(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

}
