package org.prvn.labs.order.processing.orderservice.mappers;

import org.mapstruct.Mapper;
import org.prvn.labs.order.processing.orderservice.domain.Order;
import org.prvn.labs.order.processing.orderservice.web.model.OrderDto;

@Mapper
public interface OrderMapper {
    OrderDto toOrderDto(Order order);
    Order toOrder(OrderDto orderDto);
}
