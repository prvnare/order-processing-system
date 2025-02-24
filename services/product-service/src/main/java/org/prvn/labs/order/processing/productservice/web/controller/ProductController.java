package org.prvn.labs.order.processing.productservice.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.prvn.labs.order.processing.productservice.service.ProductService;
import org.prvn.labs.order.processing.productservice.web.model.ProductRequest;
import org.prvn.labs.order.processing.productservice.web.model.ProductResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("productId") UUID productId) {
        return ResponseEntity.ok().body(productService.getProductById(productId));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        ProductResponse savedProduct = productService.saveProduct(productRequest);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(URI.create("/api/v1/products/" + savedProduct.getId()));
        return new ResponseEntity<>(responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> updateProduct(@PathVariable("productId") UUID productId, @Valid @RequestBody ProductRequest productRequest) {
        // TODO handle the actual logic here
        productService.updateProduct(productId, productRequest);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID productId) {
        productService.deleteProductById(productId);
        return ResponseEntity.noContent().build();
    }
}