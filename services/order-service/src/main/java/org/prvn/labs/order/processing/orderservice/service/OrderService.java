package org.prvn.labs.order.processing.orderservice.service;

import org.prvn.labs.order.processing.orderservice.web.model.OrderDto;

import java.util.UUID;

public interface OrderService {
    OrderDto getOrderById(UUID id);
    OrderDto saveOrder(OrderDto orderDto);

    void updateOrderStatus(UUID id, OrderDto orderDto);

    void deleteOrderById(UUID id);
}
