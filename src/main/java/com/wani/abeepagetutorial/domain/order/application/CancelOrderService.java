package com.wani.abeepagetutorial.domain.order.application;

import com.wani.abeepagetutorial.domain.order.infra.CancelPolicy;
import com.wani.abeepagetutorial.domain.order.entity.Canceller;
import com.wani.abeepagetutorial.domain.order.entity.Order;
import com.wani.abeepagetutorial.domain.order.exception.NoOrderException;
import com.wani.abeepagetutorial.domain.order.repository.OrderRepository;
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

        Order order = findOrder(orderId);
    }

    private Order findOrder(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(NoOrderException::new);
    }
}
