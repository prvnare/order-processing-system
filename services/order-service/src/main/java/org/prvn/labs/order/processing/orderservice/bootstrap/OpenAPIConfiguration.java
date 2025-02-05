package org.prvn.labs.order.processing.orderservice.bootstrap;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(
        title = "Order Processing System",
        description = "Order Processing System",
        version = "1.0",
        summary = "Order Processing System",
        contact = @Contact(
                name = "Praveen Are",
                email = "dummy@gmail.com")
        ),
servers = {
        @Server(
                description = "Local Server",
                url = "http://localhost:9091"
        )
})
public class OpenAPIConfiguration {
}
