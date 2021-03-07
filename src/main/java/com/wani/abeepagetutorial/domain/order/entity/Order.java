package com.wani.abeepagetutorial.domain.order.entity;

import com.wani.abeepagetutorial.domain.common.AbstractEntity;
import com.wani.abeepagetutorial.domain.member.entity.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;


    @OneToOne(fetch = FetchType.LAZY)
    private Member orderer;


}
