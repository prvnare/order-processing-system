package org.prvn.labs.order.processing.orderservice.web.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {

    @Null
    private UUID id;

    @NotNull(message = "customerId should not be null")
    private UUID customerId;

    @NotNull(message = "totalPrice should not be null")
    @DecimalMin(value = "0.0" , message = "totalPrice should not be negative")
    private Double totalPrice;

    @NotBlank(message = "status should not be blank or null")
    private String status;

    @NotBlank(message = "paymentStatus should not be blank or null")
    private String paymentStatus;

    @NotBlank(message = "shippingAddress should not be blank or null")
    private String shippingAddress;

    @NotBlank(message = "billingAddress should not be blank or null")
    private String billingAddress;

    @Null(message = "trackingNumber should be null")
    private UUID trackingNumber;

    @Null(message = "shippingAmount should be null")
    private Double shippingAmount;

    @Null(message = "discountAmount should be null")
    private Double discountAmount;

    private Double taxAmount;
    private LocalDate expectedDeliveryDate;
    private LocalDate deliveryDate;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

}
