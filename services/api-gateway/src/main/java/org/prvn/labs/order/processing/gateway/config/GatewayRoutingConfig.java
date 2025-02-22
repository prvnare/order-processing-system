package org.prvn.labs.order.processing.gateway.config;

import org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class GatewayRoutingConfig {

    // routing to order service based on the resource
    @Bean
    public RouterFunction<ServerResponse> routes(){
        return RouterFunctions.route()
                .GET("/api/v1/orders/**", HandlerFunctions.http("http://localhost:9091"))
                .before(BeforeFilterFunctions.addRequestHeader("Name","Praveen"))
                .before(BeforeFilterFunctions.addRequestHeadersIfNotPresent("User-Agent:Praveen"))
                .build();
    }
}
