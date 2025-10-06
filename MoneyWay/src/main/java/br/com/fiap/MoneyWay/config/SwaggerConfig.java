package br.com.fiap.MoneyWay.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

public class SwaggerConfig {
    
    OpenAPI config() {
        return new OpenAPI()
            .info(new Info()
                .contact(new Contact()
                    .email("joao@fiap.com")
                    .name("João")
                    )
                    .description("Uma API para o projeto de controle financeiro")
                    .title("API Financewalk")
                    .version("1.0")
            );
    }
}
