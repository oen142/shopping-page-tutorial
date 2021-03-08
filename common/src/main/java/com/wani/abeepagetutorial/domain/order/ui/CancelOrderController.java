package com.wani.abeepagetutorial.domain.order.ui;

import com.wani.abeepagetutorial.domain.common.service.ResponseService;
import com.wani.abeepagetutorial.domain.common.vo.ResultResponse;
import com.wani.abeepagetutorial.domain.order.application.CancelOrderService;
import com.wani.abeepagetutorial.domain.order.response.CancelOrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CancelOrderController {

    private final CancelOrderService cancelOrderService;
    private final ResponseService responseService;

    @GetMapping("/orders/{id}/cancel")
    public ResponseEntity<ResultResponse<CancelOrderResponse>> getCancelOrders(
            @PathVariable("id") Long orderId,

            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        CancelOrderResponse response = cancelOrderService.findCancelOrders(orderId, page, size);
        return ResponseEntity.ok().body(responseService.getResultResponse(response));
    }

}
