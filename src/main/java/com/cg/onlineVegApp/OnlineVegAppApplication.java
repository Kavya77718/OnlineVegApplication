package com.cg.onlineVegApp;
import org.apache.logging.log4j.LogManager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cg.vegetable.repository.ICustomerRepository;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class OnlineVegAppApplication {

	org.apache.logging.log4j.Logger logger = LogManager.getLogger();
	
	public static void main(String[] args) {
		SpringApplication.run(OnlineVegAppApplication.class, args);
	}
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.paths(PathSelectors.any())
			.build();
	}
	
	@Bean
	CommandLineRunner cmdLineRunner(ICustomerRepository CustRepo) {
		return args -> {
	};
	}

}
