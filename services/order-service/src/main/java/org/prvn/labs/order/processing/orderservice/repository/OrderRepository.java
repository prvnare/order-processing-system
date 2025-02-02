package org.prvn.labs.order.processing.orderservice.repository;

import org.prvn.labs.order.processing.orderservice.domain.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<Order, UUID> {
}
