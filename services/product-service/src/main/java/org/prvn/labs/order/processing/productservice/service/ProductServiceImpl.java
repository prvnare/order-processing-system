package org.prvn.labs.order.processing.productservice.service;

import lombok.extern.slf4j.Slf4j;
import org.prvn.labs.order.processing.productservice.web.model.ProductDto;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public ProductDto getProductById(Long productId) {
        return ProductDto.builder()
                .id(productId)
                .brand("PUMA")
                .name("shoes")
                .price(1000.00)
                .sku("PUMA - 001")
                .stock(100)
                .category("Footwear")
                .status("Available")
                .supplierId(100)
                .discount(35.00)
                .description("puma shoes for running")
                .build();
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        return productDto;
    }

    @Override
    public void updateProduct(Long productId, ProductDto productDto) {
        // do nothing here
    }

    @Override
    public void deleteProductById(Long productId) {
        log.debug("Delete product by id: {}", productId);
    }

}
