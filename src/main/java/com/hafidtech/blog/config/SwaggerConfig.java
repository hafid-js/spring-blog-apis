package com.hafidtech.blog.config;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Configuration
@OpenAPIDefinition(info = @Info(title = "Blogging Application : Backend", version = "v1", description = "This project is developed by HafidTech", termsOfService = "Term of Service"))
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class SwaggerConfig {

//    public static final String AUTHORIZATION_HEADER="Authorization";
//    private ApiKey apiKeys() {
//        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
//    }
//    private List<springfox.documentation.spi.service.contexts.SecurityContext> securityContexts() {
//        return Arrays.asList(SecurityContext.builder().securityReferences(sf()).build());
//    }
//
//    private List<SecurityReference> sf() {
//        AuthorizationScope scope = new AuthorizationScope("global", "accessEverything");
//
//        return Arrays.asList(new SecurityReference("JWT", new AuthorizationScope[]{scope}));
//    }

//    @Bean
//    public OpenAPI springBlogAPI() {
//        return new OpenAPI()
//                .info(new Info().title("Blogging Application : Backend")
//                        .description("This project is developed by HafidTech")
//                        .version("v0.0.1")
//                        .termsOfService("Terms of Service")
//                        .license(new License().name("Instagram HafidTech").url("http://instagram.com/hafid-js"))
//                )
//                .externalDocs(new ExternalDocumentation()
//                        .description("Blogging Application Documentation")
//                        .url("http://localhost/9090/v3/api-docs"));
//    }


//    @Bean
//    public OpenAPI openAPI() {
//        return new OpenAPI().addSecurityItem(new SecurityRequirement().
//                        addList("Bearer Authentication"))
//                .components(new Components().addSecuritySchemes
//                        ("Bearer Authentication", createAPIKeyScheme()))
//                .info(new Info().title("My REST API")
//                        .description("Some custom description of API.")
//                        .version("1.0").contact(new Contact().name("Sallo Szrajbman")
//                                .email( "www.baeldung.com").url("salloszraj@gmail.com"))
//                        .license(new License().name("License of API")
//                                .url("API license URL")));
//    }

//    @Bean
//    public OpenAPI CustomOpenAPI() {
//        return new OpenAPI()
//                .addSecurityItem(new SecurityRequirement().addList("bearAuth", Arrays.asList("read", "write")))
//                .components(new Components()
//                        .addSecuritySchemes("bearer-key", new io.swagger.v3.oas.models.security.SecurityScheme()
//                                .type(io.swagger.v3.oas.models.security.SecurityScheme.Type.HTTP)
//                                .scheme("bearer").bearerFormat("JWT")
//                                .in(io.swagger.v3.oas.models.security.SecurityScheme.In.HEADER)));
//    }

//    private SecuritySchemes createAPIKeyScheme() {
//        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
//                .bearerFormat("JWT")
//                .scheme("bearer");
//    }





//        @Bean
//    public Docket api() {
//
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(getInfo()).securityContexts(securityContexts())
//                .securitySchemes(Arrays.asList(apiKeys()))
//                .select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
//
//    };
//
//    private ApiInfo getInfo() {
//        return new ApiInfo("Blogging Application : Backend", "This project is developed by HafidTech","1.0","Term of Service", new Contact("HafidTech","https://instagram.com","afidzpratama@gmail.com"), "License of APIs", "API license URL", Collections.emptyList());
//
//    }



//    @Bean
//    public OpenAPI customOpenAPI() {
//        return new OpenAPI()
//                .components(new Components())
//                .info(new Info()
//                        .title("App_name")
//                        .description("App_description")
//                        .version("0.0.1")
//                        .termsOfService("http://swagger.io/terms/")
//                        .contact(new Contact().name("contact_name").email("contact_email_address"))
//                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
//                );
//    }


}
