package com.wani.abeepagetutorial.domain.order.application;

import com.wani.abeepagetutorial.domain.order.infra.CancelPolicy;
import com.wani.abeepagetutorial.domain.order.entity.Canceller;
import com.wani.abeepagetutorial.domain.order.entity.Orders;
import com.wani.abeepagetutorial.domain.order.exception.NoOrderException;
import com.wani.abeepagetutorial.domain.order.repository.OrderRepository;
import com.wani.abeepagetutorial.domain.order.response.CancelOrderResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CancelOrderService {

    private OrderRepository orderRepository;
    private RefundService refundService;
    private CancelPolicy cancelPolicy;

    public void cancel(Long orderId, Canceller canceller) {
        //event 캔슬을 발송한다.

        Orders orders = findOrder(orderId);
    }

    private Orders findOrder(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(NoOrderException::new);
    }

    public CancelOrderResponse findCancelOrders(Long orderId, int page, int size) {
        return null;
    }
}
