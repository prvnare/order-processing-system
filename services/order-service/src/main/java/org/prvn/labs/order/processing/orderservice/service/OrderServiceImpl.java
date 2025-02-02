package org.prvn.labs.order.processing.orderservice.service;

import org.prvn.labs.order.processing.orderservice.web.model.OrderDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public OrderDto getOrderById(UUID id) {
        return OrderDto.builder()
                .id(id)
                .customerId(UUID.randomUUID())
                .totalPrice(100.00)
                .status("IN-PROG")
                .paymentStatus("COMPLETED")
                .shippingAddress("HYD")
                .billingAddress("HYD")
                .trackingNumber(UUID.randomUUID())
                .shippingAmount(12.00)
                .discountAmount(1.00)
                .taxAmount(99.00)
                .expectedDeliveryDate(LocalDate.of(2025,10,01))
                .deliveryDate(LocalDate.of(2025,10,01))
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
    }

    @Override
    public OrderDto saveOrder(OrderDto orderDto) {
        return null;
    }

    @Override
    public void updateOrderStatus(UUID id, OrderDto orderDto) {

    }

    @Override
    public void deleteOrderById(UUID id) {

    }
}
