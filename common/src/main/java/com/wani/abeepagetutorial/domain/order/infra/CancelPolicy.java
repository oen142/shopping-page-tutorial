package com.wani.abeepagetutorial.domain.order.infra;

import com.wani.abeepagetutorial.domain.order.entity.Canceller;
import com.wani.abeepagetutorial.domain.order.entity.Orders;

public interface CancelPolicy {

    boolean hasCancellationPermission(Orders orders, Canceller canceller);
}
