package dev.rampmaster.ecommerce.inventory.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI inventoryOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Inventory API")
                        .description("Documentacion del microservicio de inventario y existencias")
                        .version("v1"))
                .addServersItem(new Server()
                        .url("/inventory")
                        .description("Context path del microservicio inventory"));
    }
}

