package com.wani.abeepagetutorial.domain.catelog.product.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("IT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InternalImage extends Image {


    @Override
    public String getUrl() {
        return "/images/original/" + getImagePath();
    }

    @Override
    public boolean hasThumbnail() {
        return true;
    }

    @Override
    public String getThumbnailUrl() {
        return "/images/thumbnail/" + getImagePath();
    }
}
