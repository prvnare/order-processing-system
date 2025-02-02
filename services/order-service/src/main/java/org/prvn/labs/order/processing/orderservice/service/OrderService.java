package org.prvn.labs.order.processing.orderservice.service;

import org.prvn.labs.order.processing.orderservice.web.model.OrderDto;

public interface OrderService {
    OrderDto getOrderById(Long id);
    OrderDto saveOrder(OrderDto orderDto);

    void updateOrderStatus(Long id, OrderDto orderDto);

    void deleteOrderById(Long id);
}
