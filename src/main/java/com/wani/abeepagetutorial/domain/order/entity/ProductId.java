package com.wani.abeepagetutorial.domain.order.entity;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductId {

    @Column(name = "product_id")
    private String id;

    public ProductId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
