package com.wani.abeepagetutorial.domain.catelog.product.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("EI")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExternalImage extends Image {

    @Override
    public String getUrl() {
        return getImagePath();
    }

    @Override
    public boolean hasThumbnail() {
        return false;
    }

    @Override
    public String getThumbnailUrl() {
        return null;
    }
}
