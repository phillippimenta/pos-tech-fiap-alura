package br.com.fiap.postech.techchallenge.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.info.Contact;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API Projeto Tech Challenge Fase 1",
                version = "1.0",
                description = "API desenvolvida como trabalho de conclusão da Fase 1 da Pós Tech em Software Architecture da FIAP e Alura"
        ),
        servers = @Server(url = "http://localhost:8080")
)
public class OpenApiConfig implements WebMvcConfigurer {

    @Bean
    public OpenApiCustomizer openApiCustomizer() {
        return openApi -> {
            openApi.info(new io.swagger.v3.oas.models.info.Info()
                    .title("API Projeto Tech Challenge Fase 1")
                    .version("1.0")
                    .contact(new Contact().name("Phillip Eduardo Pimenta Forte").email("phillippimenta@gmail.com"))
                    .description("API desenvolvida como trabalho de conclusão da Fase 1 da Pós Tech em Software Architecture da FIAP e Alura")
            );
        };
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springdoc-openapi-ui/");
    }
}
