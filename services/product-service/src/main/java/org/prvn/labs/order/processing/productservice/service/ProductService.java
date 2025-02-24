package org.prvn.labs.order.processing.productservice.service;

import org.prvn.labs.order.processing.productservice.web.model.ProductRequest;
import org.prvn.labs.order.processing.productservice.web.model.ProductResponse;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    ProductResponse getProductById(UUID productId);

    ProductResponse saveProduct(ProductRequest productRequest);

    void updateProduct(UUID productId, ProductRequest productRequest);

    void deleteProductById(UUID productId);

    List<ProductResponse> getAllProducts();
}
