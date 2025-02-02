package org.prvn.labs.order.processing.orderservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {

    private UUID id;
    private UUID customerId;
    private Double totalPrice;
    private String status;
    private String paymentStatus;
    private String shippingAddress;
    private String billingAddress;
    private UUID trackingNumber;
    private Double shippingAmount;
    private Double discountAmount;
    private Double taxAmount;
    private LocalDate expectedDeliveryDate;
    private LocalDate deliveryDate;
    private Date createdAt;
    private Date updatedAt;

}
