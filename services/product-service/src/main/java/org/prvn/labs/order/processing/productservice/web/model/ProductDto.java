package org.prvn.labs.order.processing.productservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private Long id;
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
