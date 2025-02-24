package org.prvn.labs.order.processing.productservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.prvn.labs.order.processing.productservice.repository.ProductRepository;
import org.prvn.labs.order.processing.productservice.web.model.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
//Integration Test using test containers
class ProductServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ProductRepository productRepository;

	@Container
	private static final MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:4.0.10"));

	@DynamicPropertySource
	static void mongoDBProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}

	@Test
	@Order(1)
	void createProduct() throws Exception {
		ProductRequest productRequest = getProduct();
		String value = objectMapper.writeValueAsString(productRequest);
		mockMvc.perform(post("/api/v1/products")
				.contentType(MediaType.APPLICATION_JSON)
				.content(value))
				.andExpect(status().isCreated());
		Assertions.assertEquals(1, productRepository.count());
	}


	@Test
	@Order(2)
	void shouldLoadAllProducts() throws Exception {
		mockMvc.perform(get("/api/v1/products")).andExpect(status().isOk());
	}


	private ProductRequest getProduct() {
		return  ProductRequest.builder()
				.brand("Apple")
				.name("IPhone X")
				.description("Apple IPhone X")
				.sku("APPLE IPHONE X")
				.price(200.00)
				.category("Mobiles")
				.status("Available")
				.stock(100)
				.supplierId(UUID.randomUUID())
				.weight(200.00)
				.dimension("2*4")
				.imageUrl("https://apple.com")
				.discount(10.00)
				.build();
	}
}
