package org.prvn.labs.order.processing.orderservice.web.client.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.junit.jupiter.api.Test;
import org.prvn.labs.order.processing.orderservice.web.model.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@JsonTest
public class OrderTest {

    @Autowired
    ObjectMapper objectMapper;

    public OrderDto getOrderDto(){
        return OrderDto.builder()
                .id(UUID.randomUUID())
                .customerId(UUID.randomUUID())
                .totalPrice(10.00)
                .status("PENDING")
                .paymentStatus("PENDING")
                .shippingAddress("shipping address")
                .billingAddress("billing address")
                .trackingNumber(UUID.randomUUID())
                .discountAmount(100.00)
                .taxAmount(100.00)
                .expectedDeliveryDate(LocalDate.now())
                .deliveryDate(LocalDate.now())
                .createdAt(OffsetDateTime.now())
                .updatedAt(OffsetDateTime.now())
                .build();
    }


    @Test
    public void serializeToJson() throws JsonProcessingException {

        OrderDto orderDto = getOrderDto();
        String stringValue = objectMapper.writeValueAsString(orderDto);
        System.out.println(stringValue);
    }


    @Test
    public void deserializeToDTO() throws JsonProcessingException {
        String value ="{\"id\":\"d342f09d-3baa-44a4-afbd-af1b031c70ca\",\"customerId\":\"6111d5b2-28b9-4a89-b70c-6533b03b5b10\",\"totalPrice\":10.0,\"status\":\"PENDING\",\"paymentStatus\":\"PENDING\",\"shippingAddress\":\"shipping address\",\"billingAddress\":\"billing address\",\"trackingNumber\":\"55bddea4-0f90-4f9f-99e3-92308b1125db\",\"shippingAmount\":null,\"discountAmount\":100.0,\"taxAmount\":100.0,\"expectedDeliveryDate\":\"2025-02-08\",\"deliveryDate\":\"2025-02-08\",\"createdAt\":\"2025-02-08T17:42:33.893585+09:00\",\"updatedAt\":\"2025-02-08T17:42:33.893594+09:00\"}";
        OrderDto orderDto = objectMapper.readValue(value, OrderDto.class);
        System.out.println(orderDto);
    }


    @Test
    public void testOrderSnake() throws JsonProcessingException {
        OrderDto orderDto = getOrderDto();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        String s = objectMapper.writeValueAsString(orderDto);
        System.out.println(s);
        OrderDto orderDto1 = objectMapper.readValue(s, OrderDto.class);
        System.out.println(orderDto1);
    }


    @Test
    public void testOrderKebabCase() throws JsonProcessingException {
        OrderDto orderDto = getOrderDto();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.KEBAB_CASE);
        String s = objectMapper.writeValueAsString(orderDto);
        System.out.println(s);
        OrderDto orderDto1 = objectMapper.readValue(s, OrderDto.class);
        System.out.println(orderDto1);
    }

}