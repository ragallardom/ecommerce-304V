package dev.rampmaster.ecommerce.payment.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI paymentOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Payment API")
                        .description("Documentacion del microservicio de pagos")
                        .version("v1"))
                .addServersItem(new Server()
                        .url("/payment")
                        .description("Context path del microservicio payment"));
    }
}

