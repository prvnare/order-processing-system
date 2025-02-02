package org.prvn.labs.order.processing.orderservice.web.client.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.prvn.labs.order.processing.orderservice.web.client.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void getProduct() {
        Product product = productService.getProduct(UUID.randomUUID());
        Assertions.assertNotNull(product);
        System.out.println(product);
    }

}