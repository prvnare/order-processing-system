package org.prvn.labs.order.processing.productservice.mappers;

import org.mapstruct.Mapper;
import org.prvn.labs.order.processing.productservice.model.Product;
import org.prvn.labs.order.processing.productservice.web.model.ProductRequest;
import org.prvn.labs.order.processing.productservice.web.model.ProductResponse;

@Mapper(uses = {DateMapper.class})
public interface ProductMapper {
    ProductResponse toProductResponse(Product product);
    Product toProduct(ProductRequest productRequest);
}