package org.prvn.labs.order.processing.productservice.service;

import org.prvn.labs.order.processing.productservice.web.model.ProductDto;

import java.util.UUID;

public interface ProductService {
    ProductDto getProductById(UUID productId);

    ProductDto saveProduct(ProductDto productDto);

    void updateProduct(UUID productId, ProductDto productDto);

    void deleteProductById(UUID productId);
}
