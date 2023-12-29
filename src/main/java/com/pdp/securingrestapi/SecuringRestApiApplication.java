package com.pdp.securingrestapi;

import com.pdp.securingrestapi.entity.Role;
import com.pdp.securingrestapi.entity.User;
import com.pdp.securingrestapi.repository.RoleRepository;
import com.pdp.securingrestapi.repository.UserRepository;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
/*@OpenAPIDefinition(
        info = @Info(
                title = "Spring 6 Swagger With Annotation Config",
                version = "3",
                contact = @Contact(
                        name = "Akobir Toshtemirov",
                        email = "example@gmail.com",
                        url = "https://github.com/AkobirToshtemirov"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://springdoc.org"),
                termsOfService = "http://swagger.io/terms/",
                description = "Spring 6 Swagger Simple Application"
        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring 6 Wiki Documentation", url = "https://springshop.wiki.github.org/docs"
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "Production-Server"
                ),
                @Server(
                        url = "http://localhost:9090",
                        description = "Test-Server"
                )
        }
)*/
public class SecuringRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecuringRestApiApplication.class, args);
    }

    @Bean
    public ApplicationRunner initializeData(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            Role userRole = Role.builder().name("USER").code("USER").build();
            Role managerRole = Role.builder().name("MANAGER").code("MANAGER").build();
            Role adminRole = Role.builder().name("ADMIN").code("ADMIN").build();

            roleRepository.saveAll(Arrays.asList(userRole, managerRole, adminRole));

            User user = User.builder()
                    .username("user")
                    .password(passwordEncoder.encode("user"))
                    .roles(Arrays.asList(userRole))
                    .build();

            User manager = User.builder()
                    .username("manager")
                    .password(passwordEncoder.encode("manager"))
                    .roles(Arrays.asList(managerRole))
                    .build();

            User admin = User.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("admin"))
                    .roles(Arrays.asList(adminRole))
                    .build();

            userRepository.saveAll(Arrays.asList(user, manager, admin));
        };
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring 6 Swagger 2 Annotation Example")
                        .description("Spring 6 Swagger Simple Application")
                        .version("3")
                        .contact(new Contact()
                                .name("Akobir Toshtemirov")
                                .email("example@gmail.com")
                                .url("https://github.com/AkobirToshtemirov"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org"))
                        .termsOfService("http://swagger.io/terms/"))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("Production Server"),
                        new Server()
                                .url("http://localhost:9090")
                                .description("Test Server")
                )).addSecurityItem(new SecurityRequirement().addList("sdf"))
                .components(new Components()
                        .addSecuritySchemes("basicAuth", new SecurityScheme()
                                .name("basicAuth")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("basic")));
    }
}
