package org.prvn.labs.order.processing.productservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.prvn.labs.order.processing.productservice.mappers.ProductMapper;
import org.prvn.labs.order.processing.productservice.model.Product;
import org.prvn.labs.order.processing.productservice.repository.ProductRepository;
import org.prvn.labs.order.processing.productservice.web.model.ProductRequest;
import org.prvn.labs.order.processing.productservice.web.model.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Override
    public ProductResponse getProductById(UUID productId) {
       return null;
    }

    @Override
    public ProductResponse saveProduct(ProductRequest productRequest) {
        Product product = productMapper.toProduct(productRequest);
        productRepository.save(product);
        return productMapper.toProductResponse(product);
    }

    @Override
    public void updateProduct(UUID productId, ProductRequest productRequest) {
        // do nothing here
    }

    @Override
    public void deleteProductById(UUID productId) {
        log.debug("Delete product by id: {}", productId);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> all = productRepository.findAll();
        return all.stream().map(productMapper::toProductResponse).toList();
    }

}
