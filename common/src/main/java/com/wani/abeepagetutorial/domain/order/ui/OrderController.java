package com.wani.abeepagetutorial.domain.order.ui;

import com.wani.abeepagetutorial.domain.common.service.ResponseService;
import com.wani.abeepagetutorial.domain.common.vo.ResultResponse;
import com.wani.abeepagetutorial.domain.member.entity.Member;
import com.wani.abeepagetutorial.domain.order.application.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final ResponseService responseService;

    @PostMapping("/orders")
    public ResponseEntity<ResultResponse<OrderResponse>> order() {
        Member member = getMemberWithSecurity();


        OrderResponse response = orderService.order();
        return ResponseEntity.ok().body(responseService.getResultResponse(response));
    }

    private Member getMemberWithSecurity() {
        return (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
