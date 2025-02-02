package org.prvn.labs.order.processing.orderservice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@Entity(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false, unique = true, length = 36, columnDefinition =  "varchar")
    private UUID id;

    @Column(nullable = false, length = 36, unique = true, updatable = false, columnDefinition = "varchar")
    private UUID customerId;

    @Column(nullable = false)
    private Double totalPrice;

    @Column
    private String status;

    @Column
    private String paymentStatus;

    @Column
    private String shippingAddress;

    @Column
    private String billingAddress;

    @Column(unique = true, nullable = false, columnDefinition = "varchar")
    private UUID trackingNumber;

    @Column
    private Double shippingAmount;

    @Column
    private Double discountAmount;

    @Column
    private Double taxAmount;

    @Column(columnDefinition = "date")
    private LocalDate expectedDeliveryDate;

    @Column(columnDefinition = "date")
    private LocalDate deliveryDate;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "timestamp")
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(columnDefinition = "timestamp")
    private Date updatedAt;
}
