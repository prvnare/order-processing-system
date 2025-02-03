package org.prvn.labs.order.processing.productservice.web.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
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
public class ProductDto {

    @Null
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private Double price;

    @Null
    private String imageUrl;

    @Null
    private String category;

    @NotNull
    private String brand;

    @NotNull
    private Integer stock;

    @NotNull
    private Double weight;

    @NotNull
    private String dimension;

    private Timestamp created;
    private Timestamp updated;

    @NotNull
    private UUID supplierId;

    @NotNull
    private Double discount;

    @NotNull
    private String status;

    @Null
    private String sku;
}
