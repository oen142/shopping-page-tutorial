package com.wani.abeepagetutorial.domain.order.repository;

import com.wani.abeepagetutorial.domain.order.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
