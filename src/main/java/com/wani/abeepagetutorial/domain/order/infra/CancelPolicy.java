package com.wani.abeepagetutorial.domain.order.infra;

import com.wani.abeepagetutorial.domain.order.entity.Canceller;
import com.wani.abeepagetutorial.domain.order.entity.Order;

public interface CancelPolicy {

    boolean hasCancellationPermission(Order order, Canceller canceller);
}
