package org.prvn.labs.order.processing.productservice.repository;

import org.prvn.labs.order.processing.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ProductRepository extends MongoRepository<Product, UUID> {
}
