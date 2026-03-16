package dev.rampmaster.ecommerce.orders.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI ordersOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Orders API")
                        .description("Documentacion del microservicio de ordenes y flujo de venta")
                        .version("v1"))
                .addServersItem(new Server()
                        .url("/orders")
                        .description("Context path del microservicio orders"));
    }
}

