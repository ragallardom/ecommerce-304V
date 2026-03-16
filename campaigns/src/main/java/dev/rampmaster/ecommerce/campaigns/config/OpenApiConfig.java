package dev.rampmaster.ecommerce.campaigns.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI campaignsOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Campaigns API")
                        .description("Documentacion del microservicio de campanas y promociones")
                        .version("v1"))
                .addServersItem(new Server()
                        .url("/campaigns")
                        .description("Context path del microservicio campaigns"));
    }
}

