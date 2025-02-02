package org.prvn.labs.order.processing.orderservice.web.client.service;

import org.prvn.labs.order.processing.orderservice.web.client.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class ProductService {

    private final String host;
    private final String endpoint;

    private final RestTemplate restTemplate;

    public ProductService(RestTemplateBuilder restTemplateBuilder,
                          @Value("${products.api.host}") String host,
                          @Value("${products.api.endpoint}") String endpoint) {
        this.restTemplate = restTemplateBuilder.build();
        this.host = host;
        this.endpoint = endpoint;
    }

    public Product getProduct(UUID productId) {
        return restTemplate.getForObject(host+endpoint+UUID.randomUUID(), Product.class, productId);
    }

}
