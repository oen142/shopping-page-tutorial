package com.wani.abeepagetutorial.domain.order.entity;

import com.wani.abeepagetutorial.domain.common.entity.AbstractEntity;
import com.wani.abeepagetutorial.domain.member.entity.Member;
import com.wani.abeepagetutorial.domain.order.exception.AlreadyShippedException;
import com.wani.abeepagetutorial.domain.order.exception.CannotEmptyOrdererException;
import com.wani.abeepagetutorial.domain.order.exception.OrderAlreadyCanceledException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Orders extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;


    @OneToOne(fetch = FetchType.LAZY)
    private Member orderer;

    @OneToMany(fetch = FetchType.LAZY)
    private List<OrderLine> orderLines = new ArrayList<>();

    private Money totalAmounts;

    @Embedded
    private ShippingInfo shippingInfo;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private LocalDateTime orderDateTime;

    @Builder
    private Orders(Member orderer, List<OrderLine> orderLines, Money totalAmounts, ShippingInfo shippingInfo, OrderStatus orderStatus, LocalDateTime orderDateTime) {
        this.orderer = orderer;
        this.orderLines = orderLines;
        this.totalAmounts = totalAmounts;
        this.shippingInfo = shippingInfo;
        this.orderStatus = orderStatus;
        this.orderDateTime = orderDateTime;
    }

    public static Orders of(Member orderer, List<OrderLine> orderLines, Money totalAmounts, ShippingInfo shippingInfo, OrderStatus orderStatus, LocalDateTime orderDateTime) {
        validOrderer(orderer);
        validOrderLines(orderLines);
        validShippingInfo(shippingInfo);
        return Orders.builder()
                .build();
    }

    private static void validShippingInfo(ShippingInfo shippingInfo) {

    }

    private static void validOrderLines(List<OrderLine> orderLines) {

    }

    private static void validOrderer(Member orderer) {
        if(orderer == null){
            throw new CannotEmptyOrdererException();
        }
    }

    public void startShipping() {
        verifyShippableState();
        this.orderStatus = OrderStatus.SHIPPED;
    }

    public void cancel() {
        verifyNotYetShipped();
        this.orderStatus = OrderStatus.CANCELED;

    }

    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        verifyNotYetShipped();
    }

    private void verifyNotYetShipped() {
        if (!isNotYetShipped()) {
            throw new AlreadyShippedException();
        }
    }

    private boolean isNotYetShipped() {
        return orderStatus == OrderStatus.PAYMENT_WAITING || orderStatus == OrderStatus.PREPARING;
    }

    private void verifyShippableState() {
        verifyNotYetShipped();
        verifyNotCanceled();
    }

    private void verifyNotCanceled() {
        if (orderStatus == OrderStatus.CANCELED) {
            throw new OrderAlreadyCanceledException();
        }
    }

}
