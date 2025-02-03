package org.prvn.labs.order.processing.orderservice.web.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
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

    @Null
    private UUID id;
    @NotNull
    private UUID customerId;
    @NotNull
    @DecimalMin("0.0")
    private Double totalPrice;
    @NotNull
    private String status;
    @NotNull
    private String paymentStatus;
    @NotNull
    private String shippingAddress;
    private String billingAddress;
    @Null
    private UUID trackingNumber;
    @NotNull
    private Double shippingAmount;
    @NotNull
    private Double discountAmount;
    @NotNull
    private Double taxAmount;
    private LocalDate expectedDeliveryDate;
    private LocalDate deliveryDate;
    private Date createdAt;
    private Date updatedAt;

}
