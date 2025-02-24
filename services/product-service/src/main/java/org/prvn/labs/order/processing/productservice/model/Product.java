package org.prvn.labs.order.processing.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {

    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private String category;
    private String brand;
    private Integer stock;
    private Double weight;
    private String dimension;
    //private Timestamp created;
    //private Timestamp updated;
    private UUID supplierId;
    private Double discount;
    private String status;
    private String sku;

}
