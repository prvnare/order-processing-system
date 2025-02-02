package org.prvn.labs.order.processing.productservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.prvn.labs.order.processing.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    // to mock the dependency beans to create the bean
    @MockitoBean
    ProductService productService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getProductById() {
      //  mockMvc.perform(get())
    }

    @Test
    void createProduct() {
    }

    @Test
    void updateProduct() {
    }

    @Test
    void getAllProducts() {
    }

    @Test
    void deleteProduct() {
    }
}