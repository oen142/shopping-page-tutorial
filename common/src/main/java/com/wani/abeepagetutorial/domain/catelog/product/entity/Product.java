package com.wani.abeepagetutorial.domain.catelog.product.entity;

import com.wani.abeepagetutorial.domain.catelog.category.entity.Category;
import com.wani.abeepagetutorial.domain.order.entity.Money;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;


    @OneToMany(fetch = FetchType.LAZY)
    private Set<Category> categories = new HashSet<>();

    private String name;

    private Money price;

    private String detail;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Image> images = new ArrayList<>();

    @Builder
    private Product(Set<Category> categories, String name, Money price, String detail, List<Image> images) {
        this.categories = categories;
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.images = images;
    }

    public static Product of(Set<Category> categories, String name, Money price, String detail, List<Image> images) {
        return Product.builder()
                .categories(categories)
                .name(name)
                .price(price)
                .detail(detail)
                .images(images)
                .build();
    }
}
