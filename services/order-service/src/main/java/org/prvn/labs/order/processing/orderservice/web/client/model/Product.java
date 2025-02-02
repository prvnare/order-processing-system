package org.prvn.labs.order.processing.orderservice.web.client.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    private UUID id;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private String category;
    private String brand;
    private Integer stock;
    private Double weight;
    private String dimension;
    private Timestamp created;
    private Timestamp updated;
    private Integer supplierId;
    private Double discount;
    private String status;
    private String sku;
}
