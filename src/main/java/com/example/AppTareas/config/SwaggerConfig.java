package com.example.AppTareas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI tareaApiOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestión de Tareas")
                        .description("Documentación interactiva del CRUD de tareas hecho por Santiago Calderón 💪")
                        .version("1.0.0"));
    }
}