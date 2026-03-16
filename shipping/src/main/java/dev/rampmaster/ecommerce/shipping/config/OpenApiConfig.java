package dev.rampmaster.ecommerce.shipping.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI shippingOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Shipping API")
                        .description("Documentacion del microservicio de envios y logistica")
                        .version("v1"))
                .addServersItem(new Server()
                        .url("/shipping")
                        .description("Context path del microservicio shipping"));
    }
}

