package com.cg.vegetable;

import org.apache.logging.log4j.LogManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class OnlineVegApplication {

	org.apache.logging.log4j.Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		SpringApplication.run(OnlineVegApplication.class, args);
	}

	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any()).build();
	}
}
