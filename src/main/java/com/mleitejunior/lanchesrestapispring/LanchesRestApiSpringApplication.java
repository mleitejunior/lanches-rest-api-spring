package com.mleitejunior.lanchesrestapispring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class LanchesRestApiSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(LanchesRestApiSpringApplication.class, args);
    }

    @Bean
    public Docket swaggerConfiguration () {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/*"))
                .apis(RequestHandlerSelectors.basePackage("com.mleitejunior"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        return new ApiInfo(
                "Lanches REST API",
                "Application to manage Sandwich Sales (MVP)",
                "1.0",
                "Free to use",
                "http://github.com/mleitejunior",
                "MIT License",
                "https://opensource.org/licenses/MIT"
        );
    }
}
