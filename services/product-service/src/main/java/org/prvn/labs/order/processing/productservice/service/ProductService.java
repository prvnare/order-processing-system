package org.prvn.labs.order.processing.productservice.service;

import org.prvn.labs.order.processing.productservice.web.model.ProductDto;

public interface ProductService {
    ProductDto getProductById(Long productId);

    ProductDto saveProduct(ProductDto productDto);

    void updateProduct(Long productId, ProductDto productDto);

    void deleteProductById(Long productId);
}
