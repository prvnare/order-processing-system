package org.prvn.labs.order.processing.orderservice.service;

import lombok.AllArgsConstructor;
import org.prvn.labs.order.processing.orderservice.domain.Order;
import org.prvn.labs.order.processing.orderservice.mappers.OrderMapper;
import org.prvn.labs.order.processing.orderservice.repository.OrderRepository;
import org.prvn.labs.order.processing.orderservice.web.model.OrderDto;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

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

    // got an exception here and worth noted
    /*
        org.hibernate.StaleObjectStateException: Row was updated or deleted by another transaction (or unsaved-value mapping was incorrect)

        Problem :
                adding ID column value manually which should be handled by the Hibernate itself
                As id column has annotated with @ID and @GeneratedValue(strategy = GenerationType.UUID)
         After removing manually setting the id value , it worked
     */
    @Override
    public OrderDto saveOrder(OrderDto orderDto) {
        Order order = orderMapper.toOrder(orderDto);
        // order.setId(UUID.randomUUID());
        order.setTrackingNumber(UUID.randomUUID());
        order.setTaxAmount(10D);
        order.setExpectedDeliveryDate(LocalDate.of(2025,10,01));
        order.setDeliveryDate(LocalDate.of(2025,10,01));
        order.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        order.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        order.setShippingAmount(100.00);
        order.setDiscountAmount(1.00);
        orderRepository.save(order);
        return orderMapper.toOrderDto(order);
    }

    @Override
    public void updateOrderStatus(UUID id, OrderDto orderDto) {

    }

    @Override
    public void deleteOrderById(UUID id) {

    }
}
