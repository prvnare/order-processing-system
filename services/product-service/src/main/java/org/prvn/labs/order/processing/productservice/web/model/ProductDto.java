package org.prvn.labs.order.processing.productservice.web.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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

    @NotNull(message = "name should not be null")
    private String name;

    @NotNull(message = "description should not be null")
    private String description;

    @NotNull(message = "price should not be null")
    @DecimalMin(value = "0.0" , message = "price should not be negative")
    private Double price;

    @Null(message = "imageUrl should be null")
    private String imageUrl;

    @Null(message = "ctegory shold be null")
    private String category;

    @NotNull(message = "brand should not be null")
    private String brand;

    @NotNull(message = "stock should not be null")
    @Min(0)
    private Integer stock;

    @NotNull(message = "wight should not be null")
    private Double weight;

    @NotNull(message = "dimension should not be null")
    @NotBlank(message = "dimension should not be blank ")
    private String dimension;

    private Timestamp created;
    private Timestamp updated;

    @NotNull(message = "supplierId should not be null")
    private UUID supplierId;

    @NotNull(message = "discount should not be null")
    @DecimalMin(value = "0.0", message = "discount should not be negative")
    private Double discount;

    @NotNull(message = "status should be null")
    private String status;

    @Null(message = "sku should be null")
    private String sku;
}
