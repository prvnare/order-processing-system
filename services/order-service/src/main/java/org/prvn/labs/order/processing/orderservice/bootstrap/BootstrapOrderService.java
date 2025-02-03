package org.prvn.labs.order.processing.orderservice.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.prvn.labs.order.processing.orderservice.domain.Order;
import org.prvn.labs.order.processing.orderservice.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

@Slf4j
@Component
public class BootstrapOrderService implements CommandLineRunner {

    private final OrderRepository orderRepository;

    public BootstrapOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (orderRepository.count() == 0) {
            orderRepository.save(Order.builder()
                            .billingAddress("Hyderabad")
                            .shippingAddress("Hyderabad")
                            .status("IN_PROGRESS")
                            .taxAmount (10D)
                            .trackingNumber(UUID.randomUUID())
                            .paymentStatus("COMPLETED")
                            .totalPrice(10000D)
                            .shippingAmount(10D)
                            .customerId(UUID.randomUUID())
                            .discountAmount(2D)
                            .deliveryDate(Date.valueOf(LocalDate.of(2025, 2, 9)))
                            .expectedDeliveryDate(Date.valueOf(LocalDate.of(2025,2,8)))
                                        .build());
            orderRepository.save(Order.builder()
                    .customerId(UUID.randomUUID())
                    .billingAddress("Chennai")
                    .shippingAddress("Chennai")
                    .status("IN_PROGRESS")
                    .taxAmount (100D)
                    .trackingNumber(UUID.randomUUID())
                    .paymentStatus("COMPLETED")
                    .totalPrice(1000D)
                    .shippingAmount(20D)
                    .discountAmount(1D)
                    .deliveryDate(Date.valueOf(LocalDate.of(2025, 2, 9)))
                    .expectedDeliveryDate(Date.valueOf(LocalDate.of(2025,2,8)))
                    .build());
            orderRepository.save(Order.builder()
                    .customerId(UUID.randomUUID())
                    .billingAddress("Delhi")
                    .shippingAddress("Delhi")
                    .status("IN_PROGRESS")
                    .taxAmount (10D)
                    .trackingNumber(UUID.randomUUID())
                    .paymentStatus("COMPLETED")
                    .totalPrice(10000D)
                    .shippingAmount(10D)
                    .discountAmount(3D)
                    .deliveryDate(Date.valueOf(LocalDate.of(2025, 2, 9)))
                    .expectedDeliveryDate(Date.valueOf(LocalDate.of(2025,2,8)))
                    .build());
        }
        log.info("Bootstrap order service started");
        log.info("Order service started successfully  with {} orders", orderRepository.count());
    }
}
